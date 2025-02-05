package com.example.prgchk1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.prgchk1.addition;
import com.example.prgchk1.ImageFrag;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ImageFrag();
            case 1:
                return new addition();

            default:
                return new ImageFrag();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of tabs
    }
}