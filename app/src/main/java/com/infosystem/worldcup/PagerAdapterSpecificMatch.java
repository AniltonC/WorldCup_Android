package com.infosystem.worldcup;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.TaskExecutor;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.time.temporal.TemporalAmount;

public class PagerAdapterSpecificMatch extends FragmentStateAdapter {
    private Match match;
    private int itemCount;

    public PagerAdapterSpecificMatch(Fragment fragment) {
        super(fragment);
    }

    public PagerAdapterSpecificMatch(Fragment fragment, int itemCount, Match match) {
        super(fragment);
        this.match = match;
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(match.getGroup() == null)
            return new InfoSpecificMatchFragment();

        switch (position){
            case 0:
                return new GroupSpecificMatchFragment();
            case 1:
                return new InfoSpecificMatchFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
}

