package com.example.android_appordercoffee.DAL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import android.util.Log;

import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.LoginCallback;
import com.example.android_appordercoffee.API.SoLuongNhanVienCallback;
import com.example.android_appordercoffee.API.RegisterNhanVienCallback;
import com.example.android_appordercoffee.DTO.NhanVienDTO;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NhanVienDAL {
    ApiService apiService = retrofit.create(ApiService.class);

    public void checkLogin(String tk, String mk, final LoginCallback callback) {
        Call<Integer> call = apiService.login(tk, mk);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int rs = response.body();
                    callback.onSuccess(rs);
                }
                else {
                    callback.onError("Không thể truy xuất dữ liệu hệ thống!");
                }
            }
            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                callback.onError("Không thể kết nối API! Lỗi: " + t.getMessage());
            }
        });
    }

    public void getSoLuongNhanVien(final SoLuongNhanVienCallback callback) {
        Call<Integer> call = apiService.getSoLuongNhanVien();
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int soLuong = response.body();
                    callback.onSuccess(soLuong);
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void registerNhanVien(NhanVienDTO nv, final RegisterNhanVienCallback callback) {
        ApiService apiService = retrofit.create(ApiService.class);

        Call<String> call = apiService.registerNhanVien(nv);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String result = response.body();
                    callback.onSuccess();
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onError();
            }
        });
    }

}
