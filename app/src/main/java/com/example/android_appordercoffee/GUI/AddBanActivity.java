package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class AddBanActivity extends AppCompatActivity {
    private Toolbar myToolbar;
    private EditText maBan, trThai;
    private Button btnThem;
    private BanBLL QLBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ban);
        // set toolbar
        myToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // mui ten quay tro lai

        maBan = findViewById(R.id.maBan);
        trThai = findViewById(R.id.trThai);
        btnThem = findViewById(R.id.btnThemBan);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = maBan.getText().toString();
                String trangThai = trThai.getText().toString();
                QLBan = new BanBLL(AddBanActivity.this);
                BanDTO ban = new BanDTO(ma, trangThai);
                QLBan.addBan(ban);
                Toast.makeText(AddBanActivity.this, "Thêm bàn thành công", Toast.LENGTH_SHORT).show();
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

}