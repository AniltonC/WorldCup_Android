package com.infosystem.worldcup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class SpecifyMatch extends Fragment {
    PagerAdapterSpecificMatch pagerAdapterSpecificMatch;
    ViewPager2 viewPager;
    private final List<String> titles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_specify_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        titles.add(getContext().getResources().getString(R.string.title_tabGroup));
        titles.add(getContext().getResources().getString(R.string.title_tabMatchInfo));
        pagerAdapterSpecificMatch = new PagerAdapterSpecificMatch(this);
        viewPager = view.findViewById(R.id.viewPagerSpecificMatch);
        viewPager.setAdapter(pagerAdapterSpecificMatch);
        TabLayout tabLayout = view.findViewById(R.id.tabBarSpecificMatch);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(titles.get(position))).attach();
    }
}