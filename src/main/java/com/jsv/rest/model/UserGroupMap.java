package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:16 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class UserGroupMap {
    private String groupId;
    private String userId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override public String toString() {
        return "UserGroupMap{" + "groupId='" + groupId + '\'' + ", userId='" + userId + '\'' + '}';
    }
}
