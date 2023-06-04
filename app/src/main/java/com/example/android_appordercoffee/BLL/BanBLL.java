package com.example.android_appordercoffee.BLL;

import android.content.Context;

import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;

import java.util.ArrayList;

public class BanBLL {
    SQLiteHelper db;
    public BanBLL(Context context) {
        db = new SQLiteHelper(context);
    }

    public ArrayList<BanDTO> getListBanKhuA(){
        return db.getListBanKhuA();
    }
    public ArrayList<BanDTO> getListBanKhuB(){
        return db.getListBanKhuB();
    }
    public long addBan(BanDTO ban) {
        return db.addBan(ban);
    }
    public int ghepBan(String TenHoaDon, String mahoadon){
        return db.ghepBan(TenHoaDon,mahoadon);
    }
}
