package com.example.laba3list;

public class MusicGroup {
    private int groupName;
    private int groupGenre;
    private int groupYearOfFoundation;
    private int groupIcon;
    private int groupDescription;
    private int groupInfo;

    public MusicGroup(int groupName, int groupGenre, int groupYearOfFoundation, int groupIcon, int groupDescription, int groupInfo) {
        this.groupName = groupName;
        this.groupGenre = groupGenre;
        this.groupYearOfFoundation = groupYearOfFoundation;
        this.groupIcon = groupIcon;
        this.groupDescription = groupDescription;
        this.groupInfo = groupInfo;
    }

    public int getGroupName() {
        return groupName;
    }

    public void setGroupName(int groupName) {
        this.groupName = groupName;
    }

    public int getGroupGenre() {
        return groupGenre;
    }

    public void setGroupGenre(int groupGenre) {
        this.groupGenre = groupGenre;
    }

    public int getGroupYearOfFoundation() {
        return groupYearOfFoundation;
    }

    public void setGroupYearOfFoundation(int groupYearOfFoundation) {
        this.groupYearOfFoundation = groupYearOfFoundation;
    }

    public int getGroupIcon() {
        return groupIcon;
    }

    public void setGroupIcon(int groupIcon) {
        this.groupIcon = groupIcon;
    }

    public int getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(int groupDescription) {
        this.groupDescription = groupDescription;
    }

    public int getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(int groupInfo) {
        this.groupInfo = groupInfo;
    }
}
