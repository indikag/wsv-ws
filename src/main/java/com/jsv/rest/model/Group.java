package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:14 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Group {
    private String groupId;
    private String groupName;

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

    @Override public String toString() {
        return "Group{" + "groupId='" + groupId + '\'' + ", groupName='" + groupName + '\'' + '}';
    }
}
