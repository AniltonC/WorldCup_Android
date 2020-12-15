package com.infosystem.worldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterMatchFrag extends RecyclerView.Adapter<RecyclerViewAdapterMatchFrag.MyViewHolder> {
    Context mContext;
    List<Match> matchList;

    public RecyclerViewAdapterMatchFrag(Context mContext, List<Match> matchList) {
        this.mContext = mContext;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_model_matchview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.item_match.setOnClickListener(v -> {
            Match match = matchList.get(myViewHolder.getAdapterPosition());
            String team_A = match.getTeam_A().getName();
            String team_B = match.getTeam_B().getName();
//            Toast.makeText(mContext, "Test Click " + team_A + " - " + team_B, Toast.LENGTH_SHORT).show();
            Fragment spcMatch = new SpecifyMatch(match);
            AppCompatActivity activity = (AppCompatActivity)v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.layoutMatches, spcMatch).addToBackStack(null).commit();
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        Match match = matchList.get(position);

        Picasso.get().load(match.getTeam_A().getIconURL()).into(viewHolder.icon_Team_A);
        Picasso.get().load(match.getTeam_B().getIconURL()).into(viewHolder.icon_Team_B);
        viewHolder.name_Team_A.setText(match.getTeam_A().getName());
        viewHolder.name_Team_B.setText(match.getTeam_B().getName());
        viewHolder.scoreboard.setText(match.getScore());
        viewHolder.goals_Team_A.setText(match.getDesc_Goals_A());
        viewHolder.goals_Team_B.setText(match.getDesc_Goals_B());
        viewHolder.status.setText(match.getStatus());
        viewHolder.description.setText(match.getDescription());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView icon_Team_A, icon_Team_B;
        TextView name_Team_A, name_Team_B, scoreboard, goals_Team_A, goals_Team_B, status, description;
        ConstraintLayout item_match;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_match = itemView.findViewById(R.id.item_Match);
            icon_Team_A = itemView.findViewById(R.id.img_ModelMatch_Icon_A);
            icon_Team_B = itemView.findViewById(R.id.img_ModelMatch_Icon_B);
            name_Team_A = itemView.findViewById(R.id.text_ModelMatch_Club_A);
            name_Team_B = itemView.findViewById(R.id.text_ModelMatch_Club_B);
            scoreboard = itemView.findViewById(R.id.text_ModelMatch_ScoreBoard);
            goals_Team_A = itemView.findViewById(R.id.text_ModelMatch_Goals_A);
            goals_Team_B = itemView.findViewById(R.id.text_ModelMatch_Goals_B);
            status = itemView.findViewById(R.id.text_ModelMatch_TimeStatus);
            description = itemView.findViewById(R.id.text_ModelMatch_Description);
        }
    }

}
