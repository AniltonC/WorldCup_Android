package com.infosystem.worldcup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    View view;
    List<Group> groupList = new ArrayList<>();
    List<Team> teamList = new ArrayList<>();
    List<Match> matchList = new ArrayList<>();
    private SQLiteDatabase database;

    public MatchesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_matches, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.matchesFragment);
        RecyclerViewAdapterMatchFrag recyclerAdapter = new RecyclerViewAdapterMatchFrag(getContext(), matchList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matchList = new ArrayList<>();
        this.database = (new Database(getContext())).getWritableDatabase();

        getDataFromDatabase();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void getDataFromDatabase() {
        String sql = "SELECT * FROM tb_teams";
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String url = cursor.getString(1);
            String group_name = cursor.getString(2);

            Group group = null;
            for(Group group1 : groupList){
                if(group1.getName().equals(group_name)){
                    group = group1;
                    break;
                }
            }
            if(group == null){
                group = new Group(group_name);
            }

            Team team = new Team(name, url, group);
            group.addTeam(team);
            groupList.add(group);
            teamList.add(team);
        }
        sql = "SELECT * FROM tb_matches";
        cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            String team_name_A = cursor.getString(1);
            String team_name_B = cursor.getString(2);
            String description = cursor.getString(3);
            String stage = cursor.getString(4);
//            String stadium = cursor.getString(5);
            String status = cursor.getString(6);
            int goals_A = cursor.getInt(7);
            String desc_goals_A = cursor.getString(8);
            desc_goals_A = updateString(desc_goals_A);
            int goals_B = cursor.getInt(9);
            String desc_goals_B = cursor.getString(10);
            desc_goals_B = updateString(desc_goals_B);

            Team team_A = null;
            for (Team team : teamList) {
                if (team.getName().equals(team_name_A)) {
                    team_A = team;
                    break;
                }
            }

            Team team_B = null;
            for (Team team : teamList) {
                if (team.getName().equals(team_name_B)) {
                    team_B = team;
                    break;
                }
            }
            if (team_A != null && team_B != null) {
                Match match = new Match(team_A, team_B, stage, status, description, team_A.getGroup());
                team_A.addGoalsF(goals_A);
                team_A.addGoalsA(goals_B);
                match.setGoals_A(goals_A);
                match.setDesc_Goals_A(desc_goals_A);

                team_B.addGoalsF(goals_B);
                team_B.addGoalsA(goals_A);
                match.setGoals_B(goals_B);
                match.setDesc_Goals_B(desc_goals_B);

                if (goals_A > goals_B) {
                    team_A.upWins();
                    team_B.upLoses();
                } else if (goals_A < goals_B) {
                    team_A.upLoses();
                    team_B.upWins();
                } else {
                    team_A.upDraws();
                    team_B.upDraws();
                }
                matchList.add(match);
            }
        }
    }

    private String updateString(String string) {
        string = string.replace('_', '\'');
        return string.replace('|', '\n');
    }


}