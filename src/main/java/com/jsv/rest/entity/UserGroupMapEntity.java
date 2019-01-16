package com.jsv.rest.entity;
/*
 * User: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:42 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "user_group_map", schema = "wsv", catalog = "") public class UserGroupMapEntity {
    private String userId;

    @Id @Column(name = "userId") public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserGroupMapEntity that = (UserGroupMapEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}
