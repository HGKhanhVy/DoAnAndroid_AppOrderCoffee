package com.example.android_appordercoffee.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.android_appordercoffee.DAL.ViewPagerAdapter;
import com.example.android_appordercoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private Toolbar myToolbar;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // set toolbar
        myToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // mui ten quay tro lai
        // set navigation
        navigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.ViewPager);
        // set on click cho floating them ban
        fab = findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddBanActivity.class);
                startActivity(intent);
            }
        });

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
                    case 0: navigationView.getMenu().findItem(R.id.soDoKhuA).setChecked(true); break;
                    case 1: navigationView.getMenu().findItem(R.id.soDoKhuB).setChecked(true); break;
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
                    case R.id.soDoKhuA: viewPager.setCurrentItem(0); break;
                    case R.id.soDoKhuB: viewPager.setCurrentItem(1); break;
                }
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        if(id == R.id.order) {
            Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
            startActivity(intent);
        }
        if(id == R.id.tamTinh) {
            Intent intent = new Intent(HomeActivity.this, HoaDonActivity.class);
            startActivity(intent);
        }
        if(id == R.id.Ct_HD) {
            Intent intent = new Intent(HomeActivity.this, ChiTietHoaDonActivity.class);
            startActivity(intent);
        }
        return true;
    }
}