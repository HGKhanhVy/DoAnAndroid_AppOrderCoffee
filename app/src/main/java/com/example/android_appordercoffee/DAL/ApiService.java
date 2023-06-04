package com.example.android_appordercoffee.DAL;

import com.example.android_appordercoffee.DTO.ThucUong_DTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("ThucUong")
    Call<List<ThucUong_DTO>> getThucUong();
}
