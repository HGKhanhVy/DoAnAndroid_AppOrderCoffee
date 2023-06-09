package com.example.android_appordercoffee.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.BLL.BanBLL;
import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.GUI.UpdateDeleteBanActivity;
import com.example.android_appordercoffee.R;

import java.util.ArrayList;

public class FragmentSoDoBan_KhuB extends Fragment { //implements BanRecycleViewAdapter.BanListener{
    private BanRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private BanBLL QLBan;
    ArrayList<BanDTO> listBanB;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sodoban_khub, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_SoDoBanKhuB);
        adapter = new BanRecycleViewAdapter();
        QLBan = new BanBLL();
        getMaBanKhuB();
    }

    @Override
    public void onResume() { // cho moi lan add la phai lam tuoi lai intent
        super.onResume();
        getMaBanKhuB();
    }
    private void getMaBanKhuB() {
        QLBan.getMaBanKhuB(new GetMaBanCallback() {
            @Override
            public void onSuccess(ArrayList<BanDTO> listB) {
                handleGetMaBan(listB);
            }
            @Override
            public void onError() {
                handleGetMaBan(new ArrayList<>());
            }
        });
    }
    private void handleGetMaBan(ArrayList<BanDTO> listB) {
        if(!listB.isEmpty()){
            listBanB = listB;
            ArrayList<BanDTO> listBan = listBanB;
            adapter.setListBan(listBan);
            GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }
    }
}
