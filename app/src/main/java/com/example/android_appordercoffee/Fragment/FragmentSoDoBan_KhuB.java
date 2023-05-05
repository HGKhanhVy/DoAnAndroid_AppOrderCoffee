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

import com.example.android_appordercoffee.DAL.BanRecycleViewAdapter;
import com.example.android_appordercoffee.DAL.SQLiteHelper;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.GUI.UpdateDeleteBanActivity;
import com.example.android_appordercoffee.R;

import java.util.List;

public class FragmentSoDoBan_KhuB extends Fragment implements BanRecycleViewAdapter.BanListener{
    private BanRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper db;
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
        db = new SQLiteHelper(getContext());
        List<BanDTO> listBan = db.getBanKhuB();
        adapter.setListBan(listBan);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setBanListener(this);
    }

    @Override
    public void onBanClick(View view, int position) {
        BanDTO ban = adapter.getBan(position);
        Intent intent = new Intent(getActivity(), UpdateDeleteBanActivity.class);
        intent.putExtra("MaBan", ban);
        startActivity(intent);
    }

    @Override
    public void onResume() { // cho moi lan add la phai lam tuoi lai intent
        super.onResume();
        List<BanDTO> list = db.getBanKhuB();
        adapter.setListBan(list);
    }
}
