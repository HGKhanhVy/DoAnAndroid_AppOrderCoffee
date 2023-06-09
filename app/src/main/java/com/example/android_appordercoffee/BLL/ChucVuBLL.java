package com.example.android_appordercoffee.BLL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import android.widget.Toast;

import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.GetTenChucVuCallback;
import com.example.android_appordercoffee.API.LoginCallback;
import com.example.android_appordercoffee.API.MaChucVuCallback;
import com.example.android_appordercoffee.DAL.ChucVuDAL;
import com.example.android_appordercoffee.DAL.NhanVienDAL;
import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.GUI.InfoActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChucVuBLL {
    private ChucVuDAL QLChucVu;
    public ChucVuBLL() {
        QLChucVu = new ChucVuDAL();
    }

    public void getTenChucVu(final GetTenChucVuCallback callback) {
        QLChucVu.getTenChucVu(new GetTenChucVuCallback() {
            @Override
            public void onSuccess(ArrayList<Item_ChucVu> list) {
                callback.onSuccess(list);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public void getMaChucVu(String tenCV, MaChucVuCallback callback) {
        QLChucVu.getMaChucVu(tenCV, callback);
    }

}
