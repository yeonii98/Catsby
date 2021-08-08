package org.techtown.catsby.community;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.techtown.catsby.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText = findViewById(R.id.edtMemo);

        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();

                if(str.length() > 0) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    String substr = sdf.format(date);

                    Intent intent = new Intent();
                    intent.putExtra("main", str);
                    intent.putExtra("sub", substr);
                    setResult(0, intent);

                    finish();


                    //Toast.makeText(AddActivity.this, str+","+substr, Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.btnNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}