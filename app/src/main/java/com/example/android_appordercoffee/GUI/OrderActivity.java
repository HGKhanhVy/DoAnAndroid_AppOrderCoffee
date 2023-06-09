package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetThucUongCallback;
import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.ThucUongBLL;
import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.MenuRecycleViewAdapter;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;
import com.example.android_appordercoffee.R;
import android.os.Bundle;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private MenuRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private ThucUongBLL QLThucUong;
    ArrayList<ThucUongDTO> listNuoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recyclerView = findViewById(R.id.rcView_Nuoc);
        adapter = new MenuRecycleViewAdapter();
        QLThucUong = new ThucUongBLL();
        getAllThucUong();
    }

    private void getAllThucUong() {
        QLThucUong.getAllThucUong(new GetThucUongCallback() {
            @Override
            public void onSuccess(ArrayList<ThucUongDTO> list) {
                handleGetThucUong(list);
            }

            @Override
            public void onError() {
                handleGetThucUong(new ArrayList<>());
            }
        });
    }
    private void handleGetThucUong(ArrayList<ThucUongDTO> list) {
        if (!list.isEmpty()) {
            listNuoc = list;
            ArrayList<ThucUongDTO> listNc = listNuoc;
            adapter.setListThucUong(listNc);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }
}