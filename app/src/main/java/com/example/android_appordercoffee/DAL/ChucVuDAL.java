package com.example.android_appordercoffee.DAL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.GetTenChucVuCallback;
import com.example.android_appordercoffee.API.LoginCallback;
import com.example.android_appordercoffee.API.MaChucVuCallback;
import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.GUI.InfoActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChucVuDAL {
    ApiService apiService = retrofit.create(ApiService.class);

    public void getTenChucVu(final GetTenChucVuCallback callback) {
        Call<List<String>> call = apiService.getAllTenChucVu();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    //List<String> tenChucVuList = response.body();
                    if (response.body() != null) {
                        ArrayList<Item_ChucVu> listCV = new ArrayList<>();
                        for (String t : response.body()) {
                            listCV.add(new Item_ChucVu(t));
                        }
                        callback.onSuccess(listCV);
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getMaChucVu(String tenCV, MaChucVuCallback callback) {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<String> call = apiService.getMaChucVu(tenCV);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String maChucVu = response.body();
                    callback.onSuccess(maChucVu);
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
