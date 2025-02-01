package com.example.l3q1_tablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.l3q1_tablayout.albums;
import com.example.l3q1_tablayout.artists;
import com.example.l3q1_tablayout.sonngs;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new artists(); // Top Stories tab
            case 1:
                return new albums(); // Sports tab
            case 2:
                return new sonngs(); // Entertainment tab
            default:
                return new artists(); // Default
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of tabs
    }
}