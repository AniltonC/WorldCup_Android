package com.infosystem.worldcup;

public class Team {
    private final String name, iconURL;
    private final Group group;

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
}
