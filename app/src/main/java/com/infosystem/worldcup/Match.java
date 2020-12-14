package com.infosystem.worldcup;

public class Match {
    private final Team team_A, team_B;
    private final String stage, status;
    private Group group = null;
    private int goals_A, goals_B;

    public Match(Team team_A, Team team_B, String stage, String status) {
        this.team_A = team_A;
        this.team_B = team_B;
        this.stage = stage;
        this.status = status;
    }
    public Match(Team team_A, Team team_B, String stage, String status, Group group) {
        this.team_A = team_A;
        this.team_B = team_B;
        this.stage = stage;
        this.status = status;
        this.group = group;
    }

    public Team getTeam_A() {
        return team_A;
    }

    public Team getTeam_B() {
        return team_B;
    }

    public String getStage() {
        return stage;
    }

    public String getStatus() {
        return status;
    }

    public Group getGroup() {
        return group;
    }

    public String getScore(){
        return goals_A + " - " + goals_B;
    }

    public void setGoals_A(int goals_A) {
        this.goals_A = goals_A;
    }

    public void setGoals_B(int goals_B) {
        this.goals_B = goals_B;
    }
}
