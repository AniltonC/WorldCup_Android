package com.infosystem.worldcup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final String name;
    private List<Team> group = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public List<Team> getGroup() {
        Collections.sort(group);
        return group;
    }

    public void addTeam(Team team) {
//        if(group.size() <= 4){
        group.add(team);
//        Collections.sort(group);
//        }
    }

    public String getName() {
        return name;
    }
}
