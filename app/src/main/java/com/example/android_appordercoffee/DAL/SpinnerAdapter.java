package com.example.android_appordercoffee.DAL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_appordercoffee.DTO.Item_ChucVu;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Item_ChucVu>{

    public SpinnerAdapter(@NonNull Context context, @NonNull ArrayList<Item_ChucVu> customList) {
        super(context, 0, customList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_layout, parent, false);
        }
        Item_ChucVu item = getItem(position);
        TextView spinnerTV = convertView.findViewById(R.id.tvSpinnerLayout);
        if(item != null) {
            spinnerTV.setText(item.getTenCV());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_dropdown_layout, parent, false);
        }
        Item_ChucVu item = getItem(position);
        TextView dropDownTV = convertView.findViewById(R.id.tvDropDownLayout);
        if(item != null) {
            dropDownTV.setText(item.getTenCV());
        }
        return convertView;
    }
}
