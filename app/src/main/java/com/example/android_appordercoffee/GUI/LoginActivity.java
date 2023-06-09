package com.example.android_appordercoffee.GUI;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.LoginCallback;
import com.example.android_appordercoffee.BLL.NhanVienBLL;
import com.example.android_appordercoffee.DTO.Login;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private NhanVienBLL QLNhanVien;
    private Button btn_login;
    private TextView regis;
    private TextInputEditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        QLNhanVien = new NhanVienBLL();
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
                if(user.getText().toString().trim().equals("") || pass.getText().toString().trim().equals(""))
                {
                    thongBao("Thông báo", "Vui lòng nhập đầy đủ thông tin tài khoản và mật khẩu");
                    return;
                }
                clickLogin();
            }
        });
    }

    public void thongBao(String title, String mess) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle(title); // Thiết lập tiêu đề của dialog
        builder.setMessage(mess); // Thiết lập nội dung của dialog
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Đóng dialog
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void clickLogin() {
        QLNhanVien.checkLogin(user.getText().toString().trim(), pass.getText().toString().trim(), new LoginCallback() {
            @Override
            public void onSuccess(int result) {
                handleCheckLogin(result);
            }
            @Override
            public void onError(String rs) {
                handleCheckLogin(0);
            }
        });
    }
    private void handleCheckLogin(int result) {
        if (result > 0) {
            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
        }
        else {
            Toast.makeText(LoginActivity.this, "Hãy kiểm tra lại tài khoản/mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }
}