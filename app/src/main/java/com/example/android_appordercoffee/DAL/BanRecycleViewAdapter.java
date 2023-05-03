package com.example.android_appordercoffee.DAL;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;
import java.util.List;

public class BanRecycleViewAdapter extends RecyclerView.Adapter<BanRecycleViewAdapter.SoDoBanViewHolder>{
    private List<BanDTO> listBan;
    private BanListener banListener;
    public BanRecycleViewAdapter() {
        listBan = new ArrayList<>();
    }

    public void setBanListener(BanListener banListener) {
        this.banListener = banListener;
    }

    public void setListBan(List<BanDTO> listBan) {
        this.listBan = listBan;
        notifyDataSetChanged(); // set lai list khi co su thay doi
    }

    public BanDTO getBan(int position) {
        return listBan.get(position);

    }

    @NonNull
    @Override
    public SoDoBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_layout, parent, false);
        return new SoDoBanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoDoBanViewHolder holder, int position) {
        BanDTO ban = listBan.get(position);
        holder.btnBan.setText(ban.getMaBan());
    }

    @Override
    public int getItemCount() {
        return listBan.size();
    }

    public class SoDoBanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgGhe1, imgGhe2, imgGhe3, imgGhe4, imgGhe5, imgGhe6;
        Button btnBan;
        public SoDoBanViewHolder(@NonNull View view) {
            super(view);
            imgGhe1 = view.findViewById(R.id.img_ghe1);
            imgGhe2 = view.findViewById(R.id.img_ghe2);
            imgGhe3 = view.findViewById(R.id.img_ghe3);
            imgGhe4 = view.findViewById(R.id.img_ghe4);
            imgGhe5 = view.findViewById(R.id.img_ghe5);
            imgGhe6 = view.findViewById(R.id.img_ghe6);
            btnBan = view.findViewById(R.id.btnBan);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (banListener != null)
                banListener.onBanClick(view, getAdapterPosition());
        }
    }
    public interface BanListener {
        void onBanClick(View view, int position);
    }
}
