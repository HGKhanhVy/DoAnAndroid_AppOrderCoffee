package com.example.android_appordercoffee.DAL;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;
import com.example.android_appordercoffee.R;

import java.util.List;

public class MenuRecycleViewAdapter extends RecyclerView.Adapter<MenuRecycleViewAdapter.MenuViewHolder>{
    private List<ThucUongDTO> listNuoc;
    @NonNull
    @Override
    public MenuRecycleViewAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nuoc, parent, false);
        return new MenuRecycleViewAdapter.MenuViewHolder(view);
    }

    public void setListThucUong(List<ThucUongDTO> listNuoc) { // lay du lieu vao list
        this.listNuoc = listNuoc;
        notifyDataSetChanged(); // set lai list khi co su thay doi
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRecycleViewAdapter.MenuViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private TextView tenNuoc, gia, soLuong;
        private ImageView dauTru, dauCong;
        public MenuViewHolder(@NonNull View view) {
            super(view);
            tenNuoc = view.findViewById(R.id.txt_TenNuoc);
            gia = view.findViewById(R.id.txt_Gia);
            soLuong = view.findViewById(R.id.txt_SoLuong);
            dauTru = view.findViewById(R.id.dauTru);
            dauCong = view.findViewById(R.id.dauCong);
            //view.setOnClickListener(this);
        }

    }
}
