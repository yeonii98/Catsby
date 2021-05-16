package org.techtown.catsby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.techtown.catsby.community.FragmentCommunity;
import org.techtown.catsby.cattown.FragmentCatTown;

public class MainActivity extends AppCompatActivity {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final FragmentHome fragmenthome = new FragmentHome();
    private final FragmentCatTown fragmentcattown = new FragmentCatTown();
    private final FragmentCommunity fragmentcommunity = new FragmentCommunity();
    private final FragmentSetting fragmentsetting = new FragmentSetting();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmenthome).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch(menuItem.getItemId())
            {
                case R.id.iconHome:
                    transaction.replace(R.id.frameLayout, fragmenthome).commitAllowingStateLoss();
                    break;
                case R.id.iconCommunity:
                    transaction.replace(R.id.frameLayout, fragmentcommunity).commitAllowingStateLoss();
                    break;
                case R.id.iconCatTown:
                    transaction.replace(R.id.frameLayout, fragmentcattown).commitAllowingStateLoss();
                    break;
                case R.id.iconSetting:
                    transaction.replace(R.id.frameLayout, fragmentsetting).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}