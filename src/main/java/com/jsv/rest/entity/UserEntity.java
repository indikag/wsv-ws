package com.jsv.rest.entity;
/*
 * User: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:42 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import javax.persistence.*;

@Entity @Table(name = "user", schema = "wsv", catalog = "") public class UserEntity {
    private String userId;
    private String userName;
    private String passworc;

    @Id @Column(name = "userId") public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic @Column(name = "userName") public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic @Column(name = "passworc") public String getPassworc() {
        return passworc;
    }

    public void setPassworc(String passworc) {
        this.passworc = passworc;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserEntity that = (UserEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
            return false;
        if (passworc != null ? !passworc.equals(that.passworc) : that.passworc != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (passworc != null ? passworc.hashCode() : 0);
        return result;
    }
}
