package com.example.android_appordercoffee.BLL;

import android.content.Context;

import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;

import java.util.ArrayList;

public class ChiTietHoaDon_BLL {
    private Context context;
    SQLiteHelper db ;
    public ChiTietHoaDon_BLL(Context context1){
        db = new SQLiteHelper(context1);
    }
    public ArrayList<CT_HoaDon_DTO> getAllChiTietHoaDon(String mahoadon){
        return db.getListCTHDByHoaDon(mahoadon);
    }
    public long AddChiTietHoaDon(CT_HoaDon_DTO ctHoaDonDto){
        return db.add_CTHoaDon(ctHoaDonDto);
    }
    public boolean KT_TonMaNuoc (String mahoadon , String mauoc){
        for(CT_HoaDon_DTO items : db.getListCTHDByHoaDon(mahoadon)){
            if(items.getMaNuoc().equalsIgnoreCase(mauoc) == true){
                return false;
            }
        }
        return true;
    }
}
