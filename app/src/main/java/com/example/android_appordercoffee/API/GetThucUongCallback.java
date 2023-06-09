package com.example.android_appordercoffee.API;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;

import java.util.ArrayList;

public interface GetThucUongCallback {
    void onSuccess(ArrayList<ThucUongDTO> list);
    void onError();
}
