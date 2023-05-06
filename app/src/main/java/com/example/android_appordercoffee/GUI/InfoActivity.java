package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.NhanVienBLL;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.R;
import com.google.android.material.textfield.TextInputEditText;

public class InfoActivity extends AppCompatActivity {
    TextInputEditText hoTen, ngSinh, sdt, email, diaChi;
    RadioButton nam, nu;
    Button btnDK;
    private NhanVienBLL QLNhanVien;
    String tk, mk;
    //AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        btnDK = findViewById(R.id.btn_DK);
        hoTen = findViewById(R.id.textInputEditText_Name);
        ngSinh = findViewById(R.id.textInputEditText_Date);
        sdt = findViewById(R.id.textInputEditText_Phone);
        email = findViewById(R.id.textInputEditText_Email);
        diaChi = findViewById(R.id.textInputEditText_DiaChi);
        nam = findViewById(R.id.rad_Nam);
        nu = findViewById(R.id.rad_Nu);

        Intent intent = getIntent();
        tk = intent.getStringExtra("user");
        mk = intent.getStringExtra("pass");
        String maNV = "NV" + java.time.LocalDate.now().toString();
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QLNhanVien = new NhanVienBLL(InfoActivity.this);
                NhanVienDTO nv = null;
                if(nam.isChecked() == true) {
                    nv = new NhanVienDTO(maNV, null, hoTen.getText().toString(), ngSinh.getText().toString(), "Nam", sdt.getText().toString(), email.getText().toString(), diaChi.getText().toString(), tk, mk);
                }
                if(nu.isChecked() == true) {
                    nv = new NhanVienDTO(maNV, null, hoTen.getText().toString(), ngSinh.getText().toString(), "Nữ", sdt.getText().toString(), email.getText().toString(), diaChi.getText().toString(), tk, mk);
                }
                QLNhanVien.addNhanVien(nv);
                Toast.makeText(InfoActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InfoActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    /*public void openDialog()
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Save your infomation");
        builder.setMessage("Your information has changed. Do you want to save the new information?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent temp = new Intent(InfoActivity.this, HomeActivity.class);
                startActivity(temp);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }*/
}