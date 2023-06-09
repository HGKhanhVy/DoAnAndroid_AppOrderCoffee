package com.example.android_appordercoffee.API;

import android.widget.Toast;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.Login;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;
import com.example.android_appordercoffee.GUI.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    // Link API: https://cd7a-2405-4802-911f-b710-acae-6fb1-f822-e027.ngrok-free.app/swagger/index.html

    // Khởi tạo Gson
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setLenient()
            .create();
    // Khởi tạo Retrofit
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cd7a-2405-4802-911f-b710-acae-6fb1-f822-e027.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    // API login
    @POST("NhanVien/Login")
    Call<Integer> login(@Query("tk") String tk, @Query("mk") String mk);

    // API lấy tên chức vụ
    @GET("ChucVu/GetAllTenChucVu")
    Call<List<String>> getAllTenChucVu();

    // API lấy mã chức vụ
    @Headers("Content-Type: application/String")
    @POST("ChucVu/GetMaChucVu")
    Call<String> getMaChucVu(@Query("tenCV") String tenCV);

    // API lấy ra số lượng nhân viên
    @GET("NhanVien/GetSoLuongNhanVien")
    Call<Integer> getSoLuongNhanVien();

    // API thêm nhân viên
    @POST("NhanVien/Register")
    Call<String> registerNhanVien(@Body NhanVienDTO nv);

    // API lấy mã bàn
    @GET("Ban/GetAllMaBan")
    Call<List<String>> getAllMaBan();

    // API thêm bàn
    @POST("Ban/ThemBan")
    Call<String> themBan(@Body BanDTO ban);

    // API lấy thức uống
    @GET("ThucUong/GetAllNuoc")
    Call<List<ThucUongDTO>> getAllThucUong();
}
