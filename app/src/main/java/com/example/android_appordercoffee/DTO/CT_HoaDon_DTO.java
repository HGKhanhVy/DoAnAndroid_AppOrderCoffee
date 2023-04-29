package com.example.android_appordercoffee.DTO;

public class CT_HoaDon_DTO {
    private String MaHoaDon, MaSanPham,TenSanPham;
    int SoLuong;
    float DonGia, ThanhTien;
    public CT_HoaDon_DTO(String MaHoaDon , String MaSP, String TenSp, int SoLuong, float DonGia,float ThanhTien){
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSP;
        this.TenSanPham = TenSp;
        this.SoLuong = SoLuong;
        this. DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }
    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        MaSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float thanhTien) {
        ThanhTien = thanhTien;
    }
}
