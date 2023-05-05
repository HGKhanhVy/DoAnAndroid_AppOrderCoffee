package com.example.android_appordercoffee.GUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_appordercoffee.R;

public class LayMaHD_Activity extends AppCompatActivity {
    TextView txt_mahd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laymahd_activity);
        txt_mahd=findViewById(R.id.txt_mahdLayDuoc);

        // Nhan Intent
        Intent myIntent = getIntent();

        //lay du lieu
        String ma=myIntent.getStringExtra("ma");
        txt_mahd.setText(ma);

    }
}
