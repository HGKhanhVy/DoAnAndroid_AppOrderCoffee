package com.example.android_appordercoffee.DTO;

public class ThucUongDTO {
    String maNuoc, maLoai, tenNuoc;
    Double gia;
    String size, trangThai;

    public String getMaNuoc() {
        return maNuoc;
    }

    public void setMaNuoc(String maNuoc) {
        this.maNuoc = maNuoc;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ThucUongDTO() {
    }

    public ThucUongDTO(String maNuoc, String maLoai, String tenNuoc, Double gia, String size, String trangThai) {
        this.maNuoc = maNuoc;
        this.maLoai = maLoai;
        this.tenNuoc = tenNuoc;
        this.gia = gia;
        this.size = size;
        this.trangThai = trangThai;
    }
    public ThucUongDTO(String tenNuoc, Double gia) {
        this.tenNuoc = tenNuoc;
        this.gia = gia;
    }
}
