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
    private String password;

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

    @Basic @Column(name = "password") public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "UserEntity{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + ", password='" + password
                + '\'' + '}';
    }
}
