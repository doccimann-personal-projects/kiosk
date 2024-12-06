package com.example.kiosk.widget.adapter.pagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class KioskItemListFragmentPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragmentList;

    public KioskItemListFragmentPagerAdapter(@NonNull Fragment fragment,
                                             @NonNull List<Fragment> fragmentList) {
        super(fragment);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
