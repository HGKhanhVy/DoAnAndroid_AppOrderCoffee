package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.RegisterNhanVienCallback;
import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class AddBanActivity extends AppCompatActivity {
    private Toolbar myToolbar;
    private EditText maBan, tenBan, trThai;
    private Button btnThem;
    private BanBLL QLBan;
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ban);
        QLBan = new BanBLL();
        // set toolbar
        myToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // mui ten quay tro lai

        maBan = findViewById(R.id.maBan);
        tenBan = findViewById(R.id.tenBan);
        trThai = findViewById(R.id.trThai);
        btnThem = findViewById(R.id.btnThemBan);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = maBan.getText().toString();
                String ten = tenBan.getText().toString();
                String trangThai = trThai.getText().toString();
                BanDTO ban = new BanDTO(ma, ten, trangThai);
                themBan(ban);
                flag = true;
                if(flag == true) {
                    Toast.makeText(AddBanActivity.this, "Thêm bàn thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddBanActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void themBan(BanDTO ban) {
        QLBan.themBan(ban, new AddBanCallback() {
            @Override
            public void onSuccess(String rs) {
                handleThemBan(rs);
            }
            @Override
            public void onError() {
            }
        });
    }
    private void handleThemBan(String rs) {
        flag = true;
    }
}