package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_appordercoffee.R;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    Button btnCon;
    TextInputEditText user, pass, rePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnCon = (Button)findViewById(R.id.btn_continue);
        user = findViewById(R.id.textInputEditText_UserName);
        pass = findViewById(R.id.textInputEditText_Pass);
        rePass = findViewById(R.id.textInputEditText_RePass);
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().trim().equals("") || pass.getText().toString().trim().equals("") || rePass.getText().toString().trim().equals(""))
                {
                    thongBao("Thông báo", "Vui lòng nhập đầy đủ thông tin tài khoản và mật khẩu");
                    return;
                }
                else if(!pass.getText().toString().trim().equals(rePass.getText().toString().trim())) {
                    thongBao("Thông báo", "Mật khẩu không trùng khớp");
                    return;
                }
                Intent intent = new Intent(RegisterActivity.this, InfoActivity.class);
                intent.putExtra("user", user.getText().toString());
                intent.putExtra("pass", pass.getText().toString());
                startActivity(intent);
            }
        });
    }
    public void thongBao(String title, String mess) {
        // Khởi tạo AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
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
        return;
    }
}