package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 2/5/19
 * Time: 6:47 PM
 * Copyright(c) 2018 AXIS, LLC.
 */


import com.jsv.rest.persistance.Group;

public class GroupModel {
    private String groupId;
    private String groupName;

    public GroupModel() {
    }

    public GroupModel(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "GroupModel{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public void convert(Group groupEntity) {
        this.setGroupId(groupEntity.getGroupName());
        this.setGroupName(groupEntity.getGroupName());
    }
}
