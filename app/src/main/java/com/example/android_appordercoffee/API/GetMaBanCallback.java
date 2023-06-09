package com.example.android_appordercoffee.API;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.Item_ChucVu;

import java.util.ArrayList;

public interface GetMaBanCallback {
    void onSuccess(ArrayList<BanDTO> list);
    void onError();
}
