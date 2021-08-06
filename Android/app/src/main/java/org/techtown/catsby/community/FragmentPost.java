package org.techtown.catsby.community;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.techtown.catsby.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentPost extends Fragment {
    private View view;
    private EditText editText;
    private TextView tv_frag2;
    private ImageButton btn_move;
    private String result;
    private Button btnDone;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_post, container, false);

        editText = view.findViewById(R.id.editMemo);
        tv_frag2 = view.findViewById(R.id.tv_frag2);
        btn_move = view.findViewById(R.id.btn_move);

        if (getArguments() != null) {
            result = getArguments().getString("fromFrag1"); ////프래그먼트커뮤니티로부터 데이터를 받아옴
            tv_frag2.setText(result);
        }

        //뒤로가기
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fromFrag2", ".");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentCommunity fragment1 = new FragmentCommunity();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.frameLayout, fragment1);
                transaction.commit(); //저장

            }
        });

        //게시버튼
        btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();

                if (str.length()>0){
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    String substr = sdf.format(date);

                    context = container.getContext();

                    Toast.makeText(context, str+","+substr, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
