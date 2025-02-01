package com.example.l3q3;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new topstories(); // Top Stories tab
            case 1:
                return new sports(); // Sports tab
            case 2:
                return new entertainment(); // Entertainment tab
            default:
                return new topstories(); // Default
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of tabs
    }
}
