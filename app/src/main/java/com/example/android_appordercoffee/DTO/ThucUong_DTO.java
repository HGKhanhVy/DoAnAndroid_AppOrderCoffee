package com.example.android_appordercoffee.DTO;

public class ThucUong_DTO {
    String manuoc , tennuoc;

    public ThucUong_DTO(String manuoc, String tennuoc) {
        this.manuoc = manuoc;
        this.tennuoc = tennuoc;
    }

    public String getManuoc() {
        return manuoc;
    }

    public void setManuoc(String manuoc) {
        this.manuoc = manuoc;
    }

    public String getTennuoc() {
        return tennuoc;
    }

    public void setTennuoc(String tennuoc) {
        this.tennuoc = tennuoc;
    }
}
