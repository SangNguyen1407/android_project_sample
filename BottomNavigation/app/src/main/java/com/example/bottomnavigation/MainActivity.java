package com.example.bottomnavigation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 pViewPager;
    private BottomNavigationView pBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pViewPager = findViewById(R.id.view_pager);
        pBottomNavigationView = findViewById(R.id.bottom_navigation);
        com.example.bottomnavigation.ViewPagerAdapter adapter = new com.example.bottomnavigation.ViewPagerAdapter(this);
        pViewPager.setAdapter(adapter);
        pViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        pBottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id){
                case R.id.tab1:
                    pViewPager.setCurrentItem(0);
                    break;
                case R.id.tab2:
                    pViewPager.setCurrentItem(1);
                    break;
                case R.id.tab3:
                    pViewPager.setCurrentItem(2);
                    break;
            }
            return true;
        });

        pViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        pBottomNavigationView.setSelectedItemId(R.id.tab1);
                        break;
                    case 1:
                        pBottomNavigationView.setSelectedItemId(R.id.tab2);
                        break;
                    case 2:
                        pBottomNavigationView.setSelectedItemId(R.id.tab3);
                        break;
                }
            }
        });
    }
}