package com.infosystem.worldcup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SpecifyMatch extends Fragment {
    PagerAdapterSpecificMatch pagerAdapterSpecificMatch;
    ViewPager2 viewPager;
    private final List<String> titles = new ArrayList<>();
    private Match match;

    public SpecifyMatch() {
    }

    public SpecifyMatch(Match match) {
       this.match = match;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_specify_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if(match != null) {

            ImageView icon_Team_A = view.findViewById(R.id.img_SpcMatch_Icon_A);
            ImageView icon_Team_B = view.findViewById(R.id.img_SpcMatch_Icon_B);
            TextView name_Team_A = view.findViewById(R.id.text_SpcMatch_Club_A);
            TextView name_Team_B = view.findViewById(R.id.text_SpcMatch_Club_B);
            TextView scoreboard = view.findViewById(R.id.text_SpcMatch_ScoreBoard);
            TextView goals_Team_A = view.findViewById(R.id.text_SpcMatch_Goals_A);
            TextView goals_Team_B = view.findViewById(R.id.text_SpcMatch_Goals_B);
            TextView status = view.findViewById(R.id.text_SpcMatch_TimeStatus);
            TextView description = view.findViewById(R.id.text_SpcMatch_Description);

            Picasso.get().load(match.getTeam_A().getIconURL()).into(icon_Team_A);
            Picasso.get().load(match.getTeam_B().getIconURL()).into(icon_Team_B);
            name_Team_A.setText(match.getTeam_A().getName());
            name_Team_B.setText(match.getTeam_B().getName());
            scoreboard.setText(match.getScore());
            goals_Team_A.setText(match.getDesc_Goals_A());
            goals_Team_B.setText(match.getDesc_Goals_B());
            status.setText(match.getStatus());
            description.setText(match.getDescription());

            //ViewPager setup
            titles.clear();
            if (match.getGroup() != null)
                titles.add(getContext().getResources().getString(R.string.title_tabGroup));
            titles.add(getContext().getResources().getString(R.string.title_tabMatchInfo));
            pagerAdapterSpecificMatch = new PagerAdapterSpecificMatch(this, titles.size(), match);
            viewPager = view.findViewById(R.id.viewPagerSpecificMatch);
            viewPager.setAdapter(pagerAdapterSpecificMatch);
            TabLayout tabLayout = view.findViewById(R.id.tabBarSpecificMatch);
            new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(titles.get(position))).attach();
        }
    }
}