package com.example.android_appordercoffee.DTO;

import java.io.Serializable;

public class NhanVienDTO implements Serializable {
    String maNV, maCV, tenNV, gioiTinh, diaChi, sdt, taiKhoan, matKhau;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String maCV, String tenNV, String gioiTinh, String diaChi, String sdt, String taiKhoan, String matKhau) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.taiKhoan = taiKhoan;
        this.matKhau = taiKhoan;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" +
                "maNV='" + maNV + '\'' +
                ", maCV='" + maCV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}