package com.example.android_appordercoffee.GUI;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.GetTenChucVuCallback;
import com.example.android_appordercoffee.API.LoginCallback;
import com.example.android_appordercoffee.API.MaChucVuCallback;
import com.example.android_appordercoffee.API.RegisterNhanVienCallback;
import com.example.android_appordercoffee.API.SoLuongNhanVienCallback;
import com.example.android_appordercoffee.BLL.ChucVuBLL;
import com.example.android_appordercoffee.BLL.NhanVienBLL;
import com.example.android_appordercoffee.DAL.SpinnerAdapter;
import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {
    private ChucVuBLL QLChucVu;
    private NhanVienBLL QLNhanVien;
    private TextInputEditText tenNV, maNV, sdt, diaChi;
    private Spinner sp_tenCV;
    private RadioButton nam, nu;
    private Button btnDK;
    private String tk, mk, maCV;
    private Boolean flag = false;
    private int slNhanVien;
    private SpinnerAdapter catAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        QLChucVu = new ChucVuBLL();
        QLNhanVien = new NhanVienBLL();

        Intent intent = getIntent();
        tk = intent.getStringExtra("user");
        mk = intent.getStringExtra("pass");
        btnDK = findViewById(R.id.btn_DK);
        tenNV = findViewById(R.id.textInputEditText_Name);
        sdt = findViewById(R.id.textInputEditText_Phone);
        diaChi = findViewById(R.id.textInputEditText_DiaChi);
        nam = findViewById(R.id.rad_Nam);
        nu = findViewById(R.id.rad_Nu);
        sp_tenCV =  findViewById(R.id.spinner_ChucVu);
        maNV = findViewById(R.id.textInputEditText_MaNV);

        // set giá trị
        getTenChucVu();
        getSoLuongNhanVien();

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tenNV.getText().toString().trim().equals("") || sdt.getText().toString().trim().equals("") || diaChi.getText().toString().trim().equals(""))
                {
                    // Khởi tạo AlertDialog.Builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                    builder.setTitle("Thông báo"); // Thiết lập tiêu đề của dialog
                    builder.setMessage("Vui lòng nhập đầy đủ thông tin tài khoản và mật khẩu"); // Thiết lập nội dung của dialog
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
                if(nam.isChecked() == true) {
                    NhanVienDTO nv = new NhanVienDTO(maNV.getText().toString().trim(), maCV, tenNV.getText().toString(), "Nam", diaChi.getText().toString(), sdt.getText().toString(), tk, mk);
                    registerNhanVien(nv);
                    flag = true;
                }
                if(nu.isChecked() == true) {
                    NhanVienDTO nv = new NhanVienDTO(maNV.getText().toString().trim(), maCV, tenNV.getText().toString(), "Nữ", diaChi.getText().toString(), sdt.getText().toString(), tk, mk);
                    registerNhanVien(nv);
                    flag = true;
                }
                if(flag == true) {
                    Toast.makeText(InfoActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(InfoActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(InfoActivity.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    private void getTenChucVu() {
        QLChucVu.getTenChucVu(new GetTenChucVuCallback() {
            @Override
            public void onSuccess(ArrayList<Item_ChucVu> list) {
                handleCheckGetTenCV(list);
            }
            @Override
            public void onError() {
                handleCheckGetTenCV(new ArrayList<>());
            }
        });
    }
    private void handleCheckGetTenCV(ArrayList<Item_ChucVu> list) {
        catAdapter = new SpinnerAdapter(InfoActivity.this, list);
        sp_tenCV.setAdapter(catAdapter);
        sp_tenCV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Item_ChucVu item = (Item_ChucVu) adapterView.getSelectedItem();
                QLChucVu.getMaChucVu(item.getTenCV(), new MaChucVuCallback() {
                    @Override
                    public void onSuccess(String maChucVu) {
                        handleGetMaCV(maChucVu);
                    }
                    @Override
                    public void onError() {
                        Toast.makeText(InfoActivity.this, "Lỗi không thể truy xuất dữ liệu mã chức vụ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void handleGetMaCV(String maChucVu) {
        maCV = maChucVu;
    }

    private void getSoLuongNhanVien() {
        QLNhanVien.getSoLuongNhanVien(new SoLuongNhanVienCallback() {
            @Override
            public void onSuccess(int soLuong) {
                handleSoLuongNhanVien(soLuong + 1);
            }
            @Override
            public void onError() {
                Toast.makeText(InfoActivity.this, "Lỗi không thể truy xuất dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleSoLuongNhanVien(int slNhanVien) {
        //Toast.makeText(InfoActivity.this, slNhanVien + "", Toast.LENGTH_SHORT).show();
        String maNhanVien;
        if(slNhanVien < 10) {
            maNhanVien = "NV0" + slNhanVien;
        }
        else {
            maNhanVien = "NV" + slNhanVien;
        }
        maNV.setText(maNhanVien);
    }

    private void registerNhanVien(NhanVienDTO nv) {
        QLNhanVien.registerNhanVien(nv, new RegisterNhanVienCallback() {
            @Override
            public void onSuccess() {
                handleRegisterNhanVien();
            }
            @Override
            public void onError() {
            }
        });
    }
    private void handleRegisterNhanVien() {
        flag = true;
    }
}