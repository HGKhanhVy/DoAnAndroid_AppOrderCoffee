package com.example.android_appordercoffee.BLL;

import com.example.android_appordercoffee.API.LoginCallback;
import com.example.android_appordercoffee.API.SoLuongNhanVienCallback;
import com.example.android_appordercoffee.API.RegisterNhanVienCallback;
import com.example.android_appordercoffee.DAL.NhanVienDAL;
import com.example.android_appordercoffee.DTO.NhanVienDTO;

public class NhanVienBLL {
    private NhanVienDAL QLNhanVien;
    public NhanVienBLL() {
        QLNhanVien = new NhanVienDAL();
    }
    public void checkLogin(String tk, String mk, final LoginCallback callback) {
        QLNhanVien.checkLogin(tk, mk, callback);
    }
    public void getSoLuongNhanVien(SoLuongNhanVienCallback callback) {
        QLNhanVien.getSoLuongNhanVien(callback);
    }

    public void registerNhanVien(NhanVienDTO nv, final RegisterNhanVienCallback callback) {
        QLNhanVien.registerNhanVien(nv, callback);
    }

}
