package com.example.android_appordercoffee.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.NhanVienDTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QL_QuanCafe.db";
    private static int DATABASE_VERSION = 1;

    private Context mContext;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    // Tao Bang
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create Table IF NOT EXISTS BAN(" +
                "MABAN TEXT NOT NULL," +
                "TRANGTHAI TEXT," +
                "CONSTRAINT PK_BAN PRIMARY KEY(MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CALAM(" +
                "MACALAM TEXT NOT NULL," +
                "TENCALAM TEXT," +
                "THOIGIANBATDAU NUMERIC," +
                "THOIGIANKETTHUC NUMERIC," +
                "CONSTRAINT PK_CALAM PRIMARY KEY(MACALAM))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CHUCVU(" +
                "MACHUCVU TEXT NOT NULL," +
                "TENCHUCVU TEXT," +
                "CONSTRAINT PK_CHUCVU PRIMARY KEY(MACHUCVU))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS KHACHHANG(" +
                "MAKHACHHANG TEXT NOT NULL," +
                "THOIGIANDEN NUMERIC," +
                "MABAN TEXT," +
                "CONSTRAINT FK_KHACHHANG_BAN FOREIGN KEY(MABAN) REFERENCES BAN(MABAN)," +
                "CONSTRAINT PK_KHACHHANG PRIMARY KEY(MAKHACHHANG))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS LOAITHUCUONG(" +
                "MALOAI TEXT NOT NULL," +
                "TENLOAI TEXT," +
                "CONSTRAINT PK_LOAITHUCUONG Primary Key (MALOAI))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS NHANVIEN(" +
                "MANHANVIEN TEXT NOT NULL," +
                "MACHUCVU TEXT," +
                "TENNHANVIEN TEXT," +
                "NGSINH TEXT," +
                "GIOITINH TEXT," +
                "EMAIL TEXT," +
                "DIACHI TEXT," +
                "SDT TEXT," +
                "TAIKHOAN TEXT," +
                "MATKHAU TEXT," +
                "CONSTRAINT PK_NHANVIEN Primary Key (MANHANVIEN)," +
                "CONSTRAINT FK_NHANVIEN_CHUCVU Foreign Key (MACHUCVU) references CHUCVU(MACHUCVU))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS NHANVIEN_CO_CALAM(" +
                "MANHANVIEN TEXT NOT NULL," +
                "MACALAM TEXT NOT NULL," +
                "THOIGIANVAO NUMERIC," +
                "THOIGIANRA NUMERIC," +
                "CONSTRAINT PK_NHANVIEN_CO_CALAM Primary Key (MANHANVIEN, MACALAM)," +
                "CONSTRAINT FK_NHANVIEN_NHANVIEN__CALAM Foreign Key (MACALAM) references CALAM (MACALAM)," +
                "CONSTRAINT FK_NHANVIEN_NHANVIEN__NHANVIEN Foreign Key (MANHANVIEN) references NHANVIEN (MANHANVIEN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS HOADON(" +
                "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," +
                "CONSTRAINT PK_HOADON Primary Key (MAHOADON)," +
                "CONSTRAINT FK_HOADON_NHANVIEN Foreign Key (MANHANVIEN) references NHANVIEN (MANHANVIEN)," +
                "CONSTRAINT FK_HOADON_BAN FOREIGN KEY (MABAN) REFERENCES BAN(MABAN))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS THUCUONG(" +
                "MANUOC TEXT NOT NULL," +
                "MALOAI TEXT," +
                "TENNUOC TEXT," +
                "GIA REAL," +
                "SIZE TEXT," +
                "TRANGTHAI TEXT," +
                "CONSTRAINT PK_THUCUONG Primary Key (MANUOC)," +
                "CONSTRAINT FK_THUCUONG_LOAITHUC Foreign Key (MALOAI) references LOAITHUCUONG (MALOAI))";
        db.execSQL(sql);
        sql = "Create Table IF NOT EXISTS CT_HOADON(" +
                "MANUOC TEXT NOT NULL," +
                "MAHOADON TEXT NOT NULL," +
                "TENNUOC TEXT," +
                "SL INTEGER," +
                "DONGIA REAL," +
                "THANHTIEN REAL," +
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
    public ArrayList<HoaDon_DTO> getListHDByHoaDon(String trangthai_ )
    {
        ArrayList<HoaDon_DTO> list = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        String query= "SELECT * FROM HOADON where TRANGTHAI ='"+trangthai_+"'";

        //Cursor rs = rdb.query("HOADON", null, null);
        Cursor rs = rdb.rawQuery(query,null);
        while(rs != null && rs.moveToNext()) {

            String maban = rs.getString(5).toString();
            String mahoadon =rs.getString(0).toString();
            String trangthai =rs.getString(4).toString();

            HoaDon_DTO hd = new HoaDon_DTO(maban,mahoadon,trangthai, null, null, null, null, null);
            list.add(hd);
        }
        return list;
    }
    public long add_HoaDon(HoaDon_DTO hd) {
        ContentValues values = new ContentValues();
        values.put("MABAN", hd.getMaban());
        values.put("MAHOADON", hd.getMahd());
        values.put("TRANGTHAI", hd.getTrangthai());

      /*  "MAHOADON TEXT NOT NULL," +
                "MANHANVIEN TEXT," +
                "TENHOADON TEXT," +
                "NGAYXUAT NUMERIC," +
                "TRANGTHAI TEXT," +
                "MABAN TEXT," +
                "GIOVAO NUMERIC," +
                "GIORA NUMERIC," + */

        values.put("MANHANVIEN", hd.getManv());
        values.put("TENHOADON", hd.getTenhd());
        values.put("NGAYXUAT", hd.getNgayxuat());
        values.put("GIOVAO", hd.getGiovao());
        values.put("GIORA", hd.getGiora());

        SQLiteDatabase databse = getWritableDatabase();
        return databse.insert("HOADON", null, values);
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
    public ArrayList<BanDTO> getListBanKhuA() {
        ArrayList<BanDTO> listA = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        Cursor rs = rdb.query("BAN", null, null,  null, null,null, null);
        while(rs != null && rs.moveToNext()) {
            String maBan = rs.getString(0);
            if(maBan.substring(0,1).equals("A"))
                listA.add(new BanDTO(maBan, "Trống"));
        }
        return listA;
    }
    public ArrayList<BanDTO> getListBanKhuB() {
        ArrayList<BanDTO> listB = new ArrayList<>();
        SQLiteDatabase rdb = getReadableDatabase();
        Cursor rs = rdb.query("BAN", null, null, null, null,null, null);
        while(rs != null && rs.moveToNext()) {
            String maBan = rs.getString(0);
            if(maBan.substring(0,1).equals("B"))
                listB.add(new BanDTO(maBan, "Trống"));
        }
        return listB;
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
    public long addNhanVien(NhanVienDTO nv) {
        ContentValues values = new ContentValues();
        values.put("MANHANVIEN", nv.getMaNV());
        values.put("MACHUCVU", nv.getMaCV());
        values.put("TENNHANVIEN", nv.getHoTen());
        values.put("NGSINH", nv.getNgSinh());
        values.put("GIOITINH", nv.getGioiTinh());
        values.put("EMAIL", nv.getEmail());
        values.put("DIACHI", nv.getDiaChi());
        values.put("SDT", nv.getSdt());
        values.put("TAIKHOAN", nv.getUser());
        values.put("MATKHAU", nv.getPass());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("NHANVIEN", null, values);
    }
    public Boolean checkDN(String tk, String mk) {
        String sql = "Select * From NHANVIEN Where TAIKHOAN = '"+tk+"' AND MATKHAU = '"+mk+"' ";
        SQLiteDatabase rdb = getReadableDatabase();
        Cursor rs = rdb.rawQuery(sql, null);
        if(rs.getCount() != 0)
            return true;
        return false;
    }
}