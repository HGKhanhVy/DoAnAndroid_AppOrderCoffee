package com.example.android_appordercoffee.BLL;

import android.content.Context;

import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.NhanVienDTO;

public class NhanVienBLL {
    SQLiteHelper db;
    public NhanVienBLL(Context context) {
        db = new SQLiteHelper(context);
    }
    public long addNhanVien(NhanVienDTO nv) {
        return db.addNhanVien(nv);
    }
    public String checkDN(String tk, String mk) {
        if (db.checkDN(tk, mk) == false)
            return "Đăng nhập không thành công";
        return "Đăng nhập thành công";
    }
}
