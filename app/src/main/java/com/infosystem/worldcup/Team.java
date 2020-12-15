package com.infosystem.worldcup;

public class Team implements Comparable<Team>{
    private final String name, iconURL;
    private final Group group;
    private int wins = 0, loses = 0, draws = 0;
    private int points = 0;
    private int goalsF = 0, goalsA = 0;
    private int matches = 0;
    public Team(String name, String iconURL, Group group) {
        this.name = name;
        this.iconURL = iconURL;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getIconURL() {
        return iconURL;
    }

    public Group getGroup() {
        return group;
    }

    public void upWins(){
        wins++;
        points += 3;
        matches++;
    }

    public void upLoses(){
        loses++;
        matches++;
    }

    public void upDraws(){
        draws++;
        points++;
        matches++;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getDraws() {
        return draws;
    }

    public int getPoint() {
        return points;
    }

    public String getPoints() {
        return Integer.toString(points);
    }

    public void addGoalsF(int goalsF){
        this.goalsF += goalsF;
    }

    public void addGoalsA(int goalsA){
        this.goalsA += goalsA;
    }

    public String getBalance(){
        return Integer.toString(goalsA - goalsF);
    }

    public String getMatches() {
        return Integer.toString(matches);
    }

    @Override
    public int compareTo(Team o) {
        return this.getPoint() - o.getPoint();
    }
}
