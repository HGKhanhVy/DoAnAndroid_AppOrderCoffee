package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.android_appordercoffee.BLL.ChiTietHoaDon_Adapter;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class ChiTietHoaDonActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiethoadon);

        listView= findViewById(R.id.listView);
        //khởi tạo data
        ArrayList<CT_HoaDon_DTO> arrList = new ArrayList<CT_HoaDon_DTO>();
        //String MaHoaDon , String MaSP, String TenSp, int SoLuong, float DonGia,float ThanhTien
        arrList.add(new CT_HoaDon_DTO("HD001","SP001","Sữa Tươi", 1,10000,10000));
        arrList.add(new CT_HoaDon_DTO("HD001","SP002","Cafe sữa", 1,15000,15000));
        arrList.add(new CT_HoaDon_DTO("HD001","SP001","Sữa Tươi", 1,10000,10000));

        ChiTietHoaDon_Adapter perAdapter = new ChiTietHoaDon_Adapter(this,arrList);
        listView.setAdapter(perAdapter);

    }
}