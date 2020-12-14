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
    //    TextView text_TeamName_A, text_TeamName_B;
//    ImageView image_Team_A, image_Team_B;
    private final List<String> titles = new ArrayList<>();
    private final Match match;

    public SpecifyMatch() {
        Team team_A = new Team("Alemanha", "https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Germany.png", null);
        Team team_B = new Team("Argentina", "https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Argentina.png", null);
        this.match = new Match(team_A, team_B, "Eliminatórias", "Full Time", null);
        this.match.setGoals_A(1);
        this.match.setGoals_B(0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_specify_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView text_TeamName_A = view.findViewById(R.id.text_SpcMatch_Club_A);
        TextView text_TeamName_B = view.findViewById(R.id.text_SpcMatch_Club_B);
        ImageView image_Team_A = view.findViewById(R.id.img_SpcMatch_Icon_A);
        ImageView image_Team_B = view.findViewById(R.id.img_SpcMatch_Icon_B);

        text_TeamName_A.setText(match.getTeam_A().getName());
        text_TeamName_B.setText(match.getTeam_B().getName());

        Picasso.get().load(match.getTeam_A().getIconURL()).into(image_Team_A);
        Picasso.get().load(match.getTeam_B().getIconURL()).into(image_Team_B);

        TextView text_MatchStatus = view.findViewById(R.id.text_SpcMatch_TimeStatus);
        text_MatchStatus.setText(match.getStatus());

        //ViewPager setup
        titles.clear();
        if (match.getGroup() != null)
 //           if (!titles.contains(title_TabGroup))
                titles.add(getContext().getResources().getString(R.string.title_tabGroup));
 //       if (!titles.contains(title_TabInfo))
            titles.add(getContext().getResources().getString(R.string.title_tabMatchInfo));
        pagerAdapterSpecificMatch = new PagerAdapterSpecificMatch(this, titles.size(), match);
        viewPager = view.findViewById(R.id.viewPagerSpecificMatch);
        viewPager.setAdapter(pagerAdapterSpecificMatch);
        TabLayout tabLayout = view.findViewById(R.id.tabBarSpecificMatch);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(titles.get(position))).attach();


//        text_TeamName_A = view.findViewById(R.id.text_SpcMatch_Club_A);
//        text_TeamName_B = view.findViewById(R.id.text_SpcMatch_Club_B);
//        image_Team_A = view.findViewById(R.id.img_SpcMatch_Icon_A);
//        image_Team_B = view.findViewById(R.id.img_SpcMatch_Icon_B);
//        Picasso.get().load("https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Brazil.png").into(image_Team_A);
//        Picasso.get().load("https://icons.veryicon.com/128/Flag/2014%20World%20Cup%20Flags/Mexico.png").into(image_Team_B);
//        text_TeamName_A.setText(R.string.title_team_brazil);
//        text_TeamName_B.setText(R.string.title_team_mexico);
        // Passar como parâmetro as seleções e o grupo, se a partida for fase de grupo
    }

    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        TextView text_TeamName_A = this.getView().findViewById(R.id.text_SpcMatch_Club_A);
//        TextView text_TeamName_B = this.getView().findViewById(R.id.text_SpcMatch_Club_B);
//        ImageView image_Team_A = this.getView().findViewById(R.id.img_SpcMatch_Icon_A);
//        ImageView image_Team_B = this.getView().findViewById(R.id.img_SpcMatch_Icon_B);
//
//        text_TeamName_A.setText(match.getTeam_A().getName());
//        text_TeamName_B.setText(match.getTeam_B().getName());
//
//        Picasso.get().load(match.getTeam_A().getIconURL()).into(image_Team_A);
//        Picasso.get().load(match.getTeam_B().getIconURL()).into(image_Team_B);
//
//        TextView text_MatchStatus = this.getView().findViewById(R.id.text_SpcMatch_TimeStatus);
//        text_MatchStatus.setText(match.getStatus());
//    }
}