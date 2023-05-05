package com.example.android_appordercoffee.DAL;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android_appordercoffee.DTO.HoaDon_DTO;
import com.example.android_appordercoffee.GUI.HoaDonActivity;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class HoaDon_Adapter extends BaseAdapter {

    private Activity activiti;
    private ArrayList<HoaDon_DTO> list ;
    public HoaDon_Adapter(View.OnClickListener activity, ArrayList<HoaDon_DTO> arrayList){
        this.activiti = (Activity) activity;
        this.list = arrayList;
    }

    public HoaDon_Adapter(HoaDonActivity hoaDonActivity, ArrayList<HoaDon_DTO> lstHoaDon) {
        this.activiti = (Activity) hoaDonActivity;
        this.list = lstHoaDon;
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

        LayoutInflater inflater = activiti.getLayoutInflater();
        view =inflater.inflate(R.layout.list_hoadon,null);

        TextView txt_Maban =(TextView) view.findViewById(R.id.txt_mahd);
        TextView txt_Mahd =(TextView) view.findViewById(R.id.txt_maban);
        TextView txt_Trangthai =(TextView) view.findViewById(R.id.txt_trangthai);

        HoaDon_DTO items = list.get(i);

        txt_Maban.setText(items.getMaban());
        txt_Mahd.setText(items.getMahd());
        txt_Trangthai.setText(items.getTrangthai());

        return view;
    }
}
