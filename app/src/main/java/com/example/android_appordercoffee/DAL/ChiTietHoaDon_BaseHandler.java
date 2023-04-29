package com.example.android_appordercoffee.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;

import androidx.annotation.Nullable;

public class ChiTietHoaDon_BaseHandler extends SQLiteOpenHelper {

    private  Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QL_QuanCafe";
    private static final String TABLE_Name = "ChiTietHoaDon";

    private static final  String KEY_MaHoaDon ="MaHoaDon";
    private static final  String KEY_MaSP ="MaSanPham";
    private static final String KEY_TENSP  = "TENSP";
    private static final String KEY_SOLUONG = "SOLUONG";
    private static final String KEY_DONGIA = "DONGIA";
    private static final String KEY_THANHTIEN = "THANHTIEN";

    public ChiTietHoaDon_BaseHandler(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
        // Create tables again

        String query ="CREATE TABLE " + TABLE_Name +  "(" +
                KEY_MaHoaDon + "TEXT PRIMARY KEY," +
                KEY_MaSP + "TEXT PRIMARY KEY,"+
                KEY_TENSP  +"TEXT, "+
                KEY_SOLUONG + " INTEGER ," +
                KEY_DONGIA + " FLOAT ," +
                KEY_THANHTIEN + " FLOAT" +
                ")"  ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
        // Create tables again
        onCreate(db);
    }
    void addChiTietHD(CT_HoaDon_DTO CT_HD) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MaHoaDon, CT_HD.getMaHoaDon());
        values.put(KEY_MaSP,CT_HD.getMaSanPham());
        values.put(KEY_TENSP, CT_HD.getTenSanPham());
        values.put(KEY_SOLUONG, CT_HD.getSoLuong());
        values.put(KEY_DONGIA, CT_HD.getDonGia());
        values.put(KEY_THANHTIEN, CT_HD.getThanhTien());

        // Inserting Row
        db.insert(TABLE_Name, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    CT_HoaDon_DTO Get_CT_HoaDon(int MaHoaDon) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_Name, new String[] { KEY_TENSP }, KEY_TENSP + "=?",
                new String[] { String.valueOf(MaHoaDon) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        //CT_HoaDon_DTO HD = new CT_HoaDon_DTO(cursor.getString(0),Integer.parseInt(cursor.getString(1)),Float.valueOf( cursor.getString(2)),Float.valueOf(cursor.getString(3)) );
        CT_HoaDon_DTO HD = new CT_HoaDon_DTO(cursor.getString(0),cursor.getString(1),cursor.getString(2),Integer.parseInt(cursor.getString(3)),Float.valueOf( cursor.getString(2)),Float.valueOf(cursor.getString(3)) );
        // return contact
        return HD;
    }
}
