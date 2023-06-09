package com.example.android_appordercoffee.DAL;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android_appordercoffee.Fragment.FragmentSoDoBan_KhuA;
import com.example.android_appordercoffee.Fragment.FragmentSoDoBan_KhuB;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    // Khi dua vao se refresh lại fragment
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FragmentSoDoBan_KhuA();
            case 1: return new FragmentSoDoBan_KhuB();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2; // Co 2 fragment
    }
}
