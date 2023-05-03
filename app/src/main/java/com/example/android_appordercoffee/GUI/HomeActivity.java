package com.example.android_appordercoffee.GUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.android_appordercoffee.DAL.ViewPagerAdapter;
import com.example.android_appordercoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.ViewPager);
        // Khi qua tro lai fragment thi se tu lam moi lai
        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch(position) {
                    case 0: navigationView.getMenu().findItem(R.id.soDo).setChecked(true); break;
                    case 1: navigationView.getMenu().findItem(R.id.order).setChecked(true); break;
                    case 2: navigationView.getMenu().findItem(R.id.tamTinh).setChecked(true); break;
                    case 3: navigationView.getMenu().findItem(R.id.tienIch).setChecked(true); break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.soDo: viewPager.setCurrentItem(0); break;
                    case R.id.order: viewPager.setCurrentItem(1); break;
                    case R.id.tamTinh: viewPager.setCurrentItem(2); break;
                    case R.id.tienIch: viewPager.setCurrentItem(3); break;
                }
                return true;
            }
        });
    }
}