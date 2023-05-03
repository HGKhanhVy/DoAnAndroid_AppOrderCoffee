package com.example.android_appordercoffee.DTO;

import java.io.Serializable;

public class BanDTO implements Serializable { // do phai gui di gui lai
    String maBan;
    String trangThai;

    public BanDTO() {
    }

    public BanDTO(String maBan, String trangThai) {
        this.maBan = maBan;
        this.trangThai = trangThai;
    }
    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
