package com.example.android_appordercoffee.DAL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetTenChucVuCallback;
import com.example.android_appordercoffee.API.RegisterNhanVienCallback;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.DTO.NhanVienDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BanDAL {
    ApiService apiService = retrofit.create(ApiService.class);

    public void getMaBanKhuA(final GetMaBanCallback callback) {
        Call<List<String>> call = apiService.getAllMaBan();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<BanDTO> listBanA = new ArrayList<>();
                        for (String t : response.body()) {
                            if(t.substring(0,1).equals("A"))
                                listBanA.add(new BanDTO(t, t, "trong"));
                        }
                        callback.onSuccess(listBanA);
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

    public void getMaBanKhuB(final GetMaBanCallback callback) {
        Call<List<String>> call = apiService.getAllMaBan();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<BanDTO> listBanA = new ArrayList<>();
                        for (String t : response.body()) {
                            if(t.substring(0,1).equals("B"))
                                listBanA.add(new BanDTO(t, t, "trong"));
                        }
                        callback.onSuccess(listBanA);
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

    public void themBan(BanDTO ban, final AddBanCallback callback) {
        ApiService apiService = retrofit.create(ApiService.class);

        Call<String> call = apiService.themBan(ban);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
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
