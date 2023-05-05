package com.example.android_appordercoffee.DTO;

import java.io.Serializable;
import java.sql.Time;

public class HoaDon_DTO implements Serializable {

    /*  "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," + */

    private String mahd, maban, trangthai, manv, tenhd, ngayxuat;
    private String  giora, giovao;

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMaban() {
        return maban;
    }

    public void setMaban(String maban) {
        this.maban = maban;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTenhd() {
        return tenhd;
    }

    public void setTenhd(String tenhd) {
        this.tenhd = tenhd;
    }

    public String getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(String ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public String getGiora() {
        return giora;
    }

    public void setGiora(String giora) {
        this.giora = giora;
    }

    public String getGiovao() {
        return giovao;
    }

    public void setGiovao(String giovao) {
        this.giovao = giovao;
    }

    public HoaDon_DTO(String mahd, String maban, String trangthai, String manv, String tenhd, String ngayxuat, String giora, String giovao) {
        this.mahd = mahd;
        this.maban = maban;
        this.trangthai = trangthai;
        this.manv = manv;
        this.tenhd = tenhd;
        this.ngayxuat = ngayxuat;
        this.giora = giora;
        this.giovao = giovao;
    }
    public HoaDon_DTO(){};

}
