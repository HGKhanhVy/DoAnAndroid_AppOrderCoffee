package com.example.android_appordercoffee.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QL_QuanCafe";
    private static int DATABASE_VERSION = 1;
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    // Tao Bang
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create Table IF NOT EXISTS BAN(" +
                "MABAN CHAR(5)," +
                "TRANGTHAI NVARCHAR(15)," +
                "CONSTRAINT  PK_BAN PRIMARY KEY (MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CALAM(" +
                "MACALAM VARCHAR(15)," +
                "TENCALAM NVARCHAR(50)," +
                "THOIGIANBATDAU TIME," +
                "THOIGIANKETTHUC TIME," +
                "CONSTRAINT PK_CALAM Primary Key (MACALAM))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CHUCVU(" +
                "MACHUCVU VARCHAR(15)," +
                "TENCHUCVU NVARCHAR(50)," +
                "CONSTRAINT PK_CHUCVU Primary Key (MACHUCVU))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS KHACHHANG(" +
                "MAKHACHHANG VARCHAR(15)," +
                "THOIGIANDEN DATETIME," +
                "MABAN VARCHAR(15)," +
                "CONSTRAINT PK_KHACHHANG Primary Key (MAKHACHHANG)," +
                "CONSTRAINT FK_KHACHHANG_BAN Foreign Key (MABAN) references BAN (MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS LOAITHUCUONG(" +
                "MALOAI VARCHAR(15)," +
                "TENLOAI NVARCHAR(30)," +
                "CONSTRAINT PK_LOAITHUCUONG Primary Key (MALOAI))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS NHANVIEN(" +
                "MANHANVIEN VARCHAR(15)," +
                "MACHUCVU VARCHAR(15)," +
                "TENNHANVIEN NVARCHAR(50)," +
                "GIOITINH NVARCHAR(4)," +
                "DIACHI NVARCHAR(100)," +
                "SDT VARCHAR(11)," +
                "TAIKHOAN VARCHAR(30)," +
                "MATKHAU VARCHAR(30)," +
                "CONSTRAINT PK_NHANVIEN Primary Key (MANHANVIEN)," +
                "CONSTRAINT FK_NHANVIEN_RELATIONS_CHUCVU Foreign Key (MACHUCVU) references CHUCVU (MACHUCVU))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS NHANVIEN_CO_CALAM(" +
                "MANHANVIEN VARCHAR(15)," +
                "MACALAM VARCHAR(15)," +
                "THOIGIANVAO DATETIME," +
                "THOIGIANRA DATETIME," +
                "CONSTRAINT PK_NHANVIEN_CO_CALAM Primary Key (MANHANVIEN, MACALAM)," +
                "CONSTRAINT FK_NHANVIEN_NHANVIEN__CALAM Foreign Key (MACALAM) references CALAM (MACALAM)," +
                "CONSTRAINT FK_NHANVIEN_NHANVIEN__NHANVIEN Foreign Key (MANHANVIEN) references NHANVIEN (MANHANVIEN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS HOADON(" +
                "MAHOADON VARCHAR(15)," +
                "MANHANVIEN VARCHAR(15)," +
                "TENHOADON NVARCHAR(20)," +
                "NGAYXUAT DATE," +
                "TRANGTHAI NVARCHAR(20)," +
                "MABAN VARCHAR(15)," +
                "GIOVAO TIME," +
                "GIORA TIME," +
                "CONSTRAINT PK_HOADON Primary Key (MAHOADON)," +
                "CONSTRAINT FK_HOADON_RELATIONS_NHANVIEN Foreign Key (MANHANVIEN) references NHANVIEN (MANHANVIEN)," +
                "CONSTRAINT FK_HOADON_BAN FOREIGN KEY (MABAN) REFERENCES BAN(MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS THUCUONG(" +
                "MANUOC VARCHAR(15)," +
                "MALOAI VARCHAR(15)," +
                "TENNUOC NVARCHAR(40)," +
                "GIA FLOAT," +
                "SIZE VARCHAR(2)," +
                "TRANGTHAI VARCHAR(20)," +
                "CONSTRAINT PK_THUCUONG Primary Key (MANUOC)," +
                "CONSTRAINT FK_THUCUONG_RELATIONS_LOAITHUC Foreign Key (MALOAI) references LOAITHUCUONG (MALOAI))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CT_HOADON(" +
                "MANUOC VARCHAR(15)," +
                "MAHOADON VARCHAR(15)," +
                "TENNUOC NVARCHAR(30)," +
                "SL INT," +
                "DONGIA FLOAT," +
                "THANHTIEN FLOAT," +
                "CONSTRAINT PK_CT_HOADON Primary Key (MANUOC, MAHOADON)," +
                "CONSTRAINT FK_CT_HOADO_CT_HOADON_THUCUONG Foreign Key (MANUOC) references THUCUONG (MANUOC)," +
                "CONSTRAINT FK_CT_HOADO_CT_HOADON_HOADON Foreign Key (MAHOADON) references HOADON (MAHOADON))";
        db.execSQL(sql);
    }
    public ArrayList<CT_HoaDon_DTO> getListCTHDByHoaDon(String MaHoaDon ){
        ArrayList<CT_HoaDon_DTO> list = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM CT_HOADON WHERE MAHOADON ='"+MaHoaDon+"'";
        //Cursor rs = rdb.query("CT_HOADON", null, null, null, null,null, null);
        Cursor rs = rdb.rawQuery(query,null);
        while(rs != null && rs.moveToNext()) {
            String maNuoc = rs.getString(0).toString();
            String maHoaDon =rs.getString(1).toString();
            String tenNuoc =rs.getString(2).toString();
            int sl =Integer.parseInt(rs.getString(3).toString());
            float donGia =Float.valueOf(rs.getString(4).toString());
            float thanhTien = Float.valueOf(rs.getString(5).toString());
            CT_HoaDon_DTO cthd = new CT_HoaDon_DTO(maHoaDon,maNuoc,tenNuoc,sl,donGia,thanhTien);
            list.add(cthd);
        }
        return list;
    }
    public long add_CTHoaDon(CT_HoaDon_DTO cthd) {
        ContentValues values = new ContentValues();
        values.put("MANUOC", cthd.getMaNuoc());
        values.put("MAHOADON", cthd.getMaHoaDon());
        values.put("TENNUOC", cthd.getTenNuoc());
        values.put("SL", cthd.getSoLuong());
        values.put("DONGIA", cthd.getDonGia());
        values.put("THANHTIEN", cthd.getThanhTien());
        SQLiteDatabase databse = getWritableDatabase();
        return databse.insert("CT_HOADON", null, values);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    // lay tat ca ban ra
    public List<BanDTO> getAll() {
        List<BanDTO> list = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        Cursor rs = rdb.query("BAN", null, null, null, null,null, null);
        while(rs != null && rs.moveToNext()) {
            String maBan = rs.getString(0);
            list.add(new BanDTO(maBan, "Trống"));
        }
        return list;
    }

    // Them - Lenh insert tra ve long - delete, update tra ve int - query, rawQuery tra ve cursor
    // execSQL void
    public long addBan(BanDTO ban) {
        ContentValues values = new ContentValues();
        values.put("MABAN", ban.getMaBan());
        values.put("TRANGTHAI", ban.getTrangThai());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("BAN", null, values);
    }
}
