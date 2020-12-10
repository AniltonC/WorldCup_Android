package com.infosystem.worldcup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapterSpecificMatch extends FragmentStateAdapter {
    public PagerAdapterSpecificMatch(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
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
        return 2;
    }


    //private final int numOfTabs;

//    public PagerAdapterSpecificMatch(@NonNull FragmentManager fm, int numOfTabs) {
//        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        this.numOfTabs = numOfTabs;
//    }

//    public PagerAdapterSpecificMatch(@NonNull FragmentManager fm, int behavior, int numOfTabs) {
//        super(fm, behavior);
//        this.numOfTabs = numOfTabs;
//    }


//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new GroupSpecificMatchFragment();
//            case 1:
//                return new InfoSpecificMatchFragment();
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return 2;
//    }
}

