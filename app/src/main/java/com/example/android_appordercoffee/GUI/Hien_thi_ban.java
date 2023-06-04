package com.example.android_appordercoffee.GUI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_appordercoffee.DAL.ChiTietHoaDon_Adapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DAL.ViewPagerAdapter;
import com.example.android_appordercoffee.DAL.hienthiBan_Adapter;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Hien_thi_ban extends AppCompatActivity {
    SQLiteHelper db ;
    ArrayList<BanDTO> listBan;
    GridView gridView ; //id GridViewItem

    //ActivityMainBinding
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_ban);

        gridView = findViewById(R.id.GridViewItem);
        db= new SQLiteHelper(Hien_thi_ban.this);
        listBan = db.getListBanKhuA();

       hienthiBan_Adapter adapter = new hienthiBan_Adapter(Hien_thi_ban.this,listBan);
       gridView.setAdapter(adapter);
    }
}