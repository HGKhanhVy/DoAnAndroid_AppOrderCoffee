package com.example.android_appordercoffee.DAL;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_appordercoffee.R;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;

import java.util.ArrayList;

public class ChiTietHoaDon_Adapter  extends BaseAdapter {
    private Activity activiti;
    private  ArrayList<CT_HoaDon_DTO> list ;
    public ChiTietHoaDon_Adapter(Activity activity, ArrayList<CT_HoaDon_DTO> arrayList){
        this.activiti = activity;
        this.list = arrayList;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //laay  view ra sài
        LayoutInflater inflater = activiti.getLayoutInflater();
        view =inflater.inflate(R.layout.listview_ct_hoadon,null);

        //đưa dữ liệu vào view
        //mã hóa đơn, mã sản phẩm , tên sản phẩm , số lượng, đơn giá , thành tiền
        TextView txt_TenSanPham =(TextView) view.findViewById(R.id.txtTenSP);
        TextView txt_DonGia =(TextView) view.findViewById(R.id.txtDonGia);
        TextView txt_SoLuong =(TextView) view.findViewById(R.id.txtSL);
        TextView txt_ThanhTien =(TextView) view.findViewById(R.id.txtThanhTien);

        //lấy môt người trong list ra
        CT_HoaDon_DTO items = list.get(i);

        txt_TenSanPham.setText(items.getTenNuoc());
        txt_DonGia.setText(String.valueOf(items.getDonGia()));
        txt_SoLuong.setText(String.valueOf(items.getSoLuong()));
        txt_ThanhTien.setText(String.valueOf(items.getThanhTien()));
        return view;
    }
}
