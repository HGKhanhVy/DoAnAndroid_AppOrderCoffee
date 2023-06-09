package com.example.android_appordercoffee.API;

import com.example.android_appordercoffee.DTO.Item_ChucVu;

import java.util.ArrayList;

public interface GetTenChucVuCallback {
    void onSuccess(ArrayList<Item_ChucVu> list);
    void onError();
}
