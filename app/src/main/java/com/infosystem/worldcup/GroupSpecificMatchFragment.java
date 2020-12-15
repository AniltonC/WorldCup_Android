package com.infosystem.worldcup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

public class GroupSpecificMatchFragment extends Fragment {

    private Group group;
    public GroupSpecificMatchFragment(Group group) {
        this.group = group;
    }

    public GroupSpecificMatchFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_group_specific_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if(group != null){
            TextView groupName = view.findViewById(R.id.text_Group_Name);

            ImageView teamIcon_1 = view.findViewById(R.id.image_TeamLogo_1);
            TextView teamName_1 = view.findViewById(R.id.text_TeamName_1);
            TextView teamMatches_1 = view.findViewById(R.id.text_TeamP_1);
            TextView teamBalance_1 = view.findViewById(R.id.text_TeamBalance_1);
            TextView teamPts_1 = view.findViewById(R.id.text_TeamPts_1);

            ImageView teamIcon_2 = view.findViewById(R.id.image_TeamLogo_2);
            TextView teamName_2 = view.findViewById(R.id.text_TeamName_2);
            TextView teamMatches_2 = view.findViewById(R.id.text_TeamP_2);
            TextView teamBalance_2 = view.findViewById(R.id.text_TeamBalance_2);
            TextView teamPts_2 = view.findViewById(R.id.text_TeamPts_2);

            ImageView teamIcon_3 = view.findViewById(R.id.image_TeamLogo_3);
            TextView teamName_3 = view.findViewById(R.id.text_TeamName_3);
            TextView teamMatches_3 = view.findViewById(R.id.text_TeamP_3);
            TextView teamBalance_3 = view.findViewById(R.id.text_TeamBalance_3);
            TextView teamPts_3 = view.findViewById(R.id.text_TeamPts_3);

            ImageView teamIcon_4 = view.findViewById(R.id.image_TeamLogo_4);
            TextView teamName_4 = view.findViewById(R.id.text_TeamName_4);
            TextView teamMatches_4 = view.findViewById(R.id.text_TeamP_4);
            TextView teamBalance_4 = view.findViewById(R.id.text_TeamBalance_4);
            TextView teamPts_4 = view.findViewById(R.id.text_TeamPts_4);

            groupName.setText(group.getName());

            Picasso.get().load(group.getGroup().get(0).getIconURL()).into(teamIcon_1);
            teamName_1.setText(group.getGroup().get(0).getName());
            teamMatches_1.setText(group.getGroup().get(0).getMatches());
            teamBalance_1.setText(group.getGroup().get(0).getBalance());
            teamPts_1.setText(group.getGroup().get(0).getPoints());

            Picasso.get().load(group.getGroup().get(1).getIconURL()).into(teamIcon_2);
            teamName_2.setText(group.getGroup().get(1).getName());
            teamMatches_2.setText(group.getGroup().get(1).getMatches());
            teamBalance_2.setText(group.getGroup().get(1).getBalance());
            teamPts_2.setText(group.getGroup().get(1).getPoints());

            Picasso.get().load(group.getGroup().get(2).getIconURL()).into(teamIcon_3);
            teamName_3.setText(group.getGroup().get(2).getName());
            teamMatches_3.setText(group.getGroup().get(2).getMatches());
            teamBalance_3.setText(group.getGroup().get(2).getBalance());
            teamPts_3.setText(group.getGroup().get(2).getPoints());

            Picasso.get().load(group.getGroup().get(3).getIconURL()).into(teamIcon_4);
            teamName_4.setText(group.getGroup().get(3).getName());
            teamMatches_4.setText(group.getGroup().get(3).getMatches());
            teamBalance_4.setText(group.getGroup().get(3).getBalance());
            teamPts_4.setText(group.getGroup().get(3).getPoints());
        }
    }
}