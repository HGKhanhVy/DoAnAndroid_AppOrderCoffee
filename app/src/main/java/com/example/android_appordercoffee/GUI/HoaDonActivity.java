package com.example.android_appordercoffee.GUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_appordercoffee.BLL.HoaDon_BLL;
import com.example.android_appordercoffee.DAL.ChiTietHoaDon_Adapter;
import com.example.android_appordercoffee.DAL.HoaDon_Adapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;
import com.example.android_appordercoffee.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HoaDonActivity extends AppCompatActivity {

    ListView listView;
    SQLiteHelper db;
    Button btn_daTT;
    Button btn_chuaTT;


    @SuppressLint("MissingInflatedId")
    public void goiList() // da thanh toan
    {
        HoaDon_BLL hd = new HoaDon_BLL(HoaDonActivity.this);


        // khởi tạo data
        HoaDon_DTO HD1 = new HoaDon_DTO("HD011", "B001", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD2 = new HoaDon_DTO("HD012", "B002", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD3 = new HoaDon_DTO("HD013", "B001", "chua thanh toan", null, null, null, null, null);
        HoaDon_DTO HD4 = new HoaDon_DTO("HD014", "B002", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD5 = new HoaDon_DTO("HD015", "B001", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD6 = new HoaDon_DTO("HD016", "B002", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD7 = new HoaDon_DTO("HD017", "B001", "chua thanh toan", null, null, null, null, null);
        HoaDon_DTO HD8 = new HoaDon_DTO("HD018", "B002", "chua thanh toan", null, null, null, null, null);
        HoaDon_DTO HD9 = new HoaDon_DTO("HD019", "B001", "thanh toan", null, null, null, null, null);

        hd.AddHoaDon(HD1);
        hd.AddHoaDon(HD2);
        hd.AddHoaDon(HD3);
        hd.AddHoaDon(HD4);
        hd.AddHoaDon(HD5);
        hd.AddHoaDon(HD6);
        hd.AddHoaDon(HD7);
        hd.AddHoaDon(HD8);
        hd.AddHoaDon(HD9);



        ArrayList<HoaDon_DTO> lstHoaDon = hd.getALLHoaDon("thanh toan");
        HoaDon_Adapter perAdapter = new HoaDon_Adapter(this, lstHoaDon);
        listView.setAdapter(perAdapter);


    }

    public void goiList1() // chua thanh toan
    {
        HoaDon_BLL hd =new HoaDon_BLL(HoaDonActivity.this);


        // khởi tạo data
        HoaDon_DTO HD1 = new HoaDon_DTO("HD011", "B001", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD2 = new HoaDon_DTO("HD012", "B002", "thanh toan",null, null, null, null, null);
        HoaDon_DTO HD3 = new HoaDon_DTO("HD013", "B001", "chua thanh toan", null, null, null, null, null);
        HoaDon_DTO HD4 = new HoaDon_DTO("HD014", "B002", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD5 = new HoaDon_DTO("HD015", "B001", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD6 = new HoaDon_DTO("HD016", "B002", "thanh toan", null, null, null, null, null);
        HoaDon_DTO HD7 = new HoaDon_DTO("HD017", "B001", "chua thanh toan", null, null, null, null, null);
        HoaDon_DTO HD8 = new HoaDon_DTO("HD018", "B002", "chua thanh toan", null, null, null, null, null);
        HoaDon_DTO HD9 = new HoaDon_DTO("HD019", "B001", "thanh toan", null, null, null, null, null);

        /*
        hd.AddHoaDon(HD1);
        hd.AddHoaDon(HD2);
        hd.AddHoaDon(HD3);
        hd.AddHoaDon(HD4);
        hd.AddHoaDon(HD5);
        hd.AddHoaDon(HD6);
        hd.AddHoaDon(HD7);
        hd.AddHoaDon(HD8);
        hd.AddHoaDon(HD9);
        */


        ArrayList<HoaDon_DTO> lstHoaDon = hd.getALLHoaDon("chua thanh toan");
        HoaDon_Adapter perAdapter = new HoaDon_Adapter( this, lstHoaDon);
        listView.setAdapter(perAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon);
        listView = findViewById(R.id.listView_hd);
        btn_daTT = findViewById(R.id.btn_dathanhtoan);
        btn_chuaTT = findViewById(R.id.btn_chuathanhtoan);

        // xu li button CHUA THANH TOAN
        btn_chuaTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goiList1();
            }
        });
        //xu li button DA THANH TOAN
        btn_daTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goiList();
            }
        });

        // xu li su kiện click vào item trong ListView
        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HoaDon_DTO hd= new HoaDon_DTO();
                String ma=hd.getMahd();
                Intent myIntent = new Intent(HoaDonActivity.this, LayMaHD_Activity.class);
                myIntent.putExtra("ma", ma);
                startActivity(myIntent);
            }
        }); */
    }

}
