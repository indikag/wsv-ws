package com.jsv.rest.entity;
/*
 * User: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:42 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import javax.persistence.*;

@Entity @Table(name = "group", schema = "wsv", catalog = "") public class GroupEntity {
    private String groupId;
    private String groupName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "groupId") public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic @Column(name = "groupName") public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GroupEntity that = (GroupEntity) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null)
            return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
