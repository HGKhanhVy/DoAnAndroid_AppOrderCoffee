package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.BLL.NhanVienBLL;
import com.example.android_appordercoffee.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private NhanVienBLL QLNhanVien;
    Button btn_login;
    TextView regis;
    TextInputEditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        regis = (TextView)findViewById(R.id.txt_register);
        user = findViewById(R.id.textInputEditText_Name);
        pass = findViewById(R.id.textInputEditText_Pass);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QLNhanVien = new NhanVienBLL(LoginActivity.this);
                String checkDN = QLNhanVien.checkDN(user.getText().toString().trim(), pass.getText().toString().trim());
                if(checkDN.equals("Đăng nhập thành công") == false) {
                    Toast.makeText(LoginActivity.this, checkDN, Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(LoginActivity.this, "0Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}