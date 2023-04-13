package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.android_appordercoffee.R;
import com.example.android_appordercoffee.DAL.MenuAdapterDAL;
import com.example.android_appordercoffee.DTO.MenuDTO;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ListView lstViewMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lstViewMenu = findViewById(R.id.lst_Menu);
        ArrayList<MenuDTO> arr = new ArrayList<>();
        while (arr.size() < 4) {
            arr.add(new MenuDTO());
        }
        MenuAdapterDAL ada = new MenuAdapterDAL(this, 0, arr);
        lstViewMenu.setAdapter(ada);
    }
}