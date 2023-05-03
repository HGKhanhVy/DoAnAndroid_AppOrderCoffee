package com.example.android_appordercoffee.DAL;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android_appordercoffee.Fragment.FragmentOrder;
import com.example.android_appordercoffee.Fragment.FragmentSoDoBan;
import com.example.android_appordercoffee.Fragment.FragmentTamTinh;
import com.example.android_appordercoffee.Fragment.FragmentTienIch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    // Khi dua vao se refresh lại fragment
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FragmentSoDoBan();
            case 1: return new FragmentOrder();
            case 2: return new FragmentTamTinh();
            case 3: return new FragmentTienIch();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4; // Co 4 fragment
    }
}
