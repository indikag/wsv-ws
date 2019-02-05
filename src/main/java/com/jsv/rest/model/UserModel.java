package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 2/5/19
 * Time: 6:47 PM
 * Copyright(c) 2018 AXIS, LLC.
 */


import com.jsv.rest.persistance.User;

public class UserModel {
    private String userId;
    private String userName;
    private String userPassword;

    public UserModel() {
    }

    public UserModel(String userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public void convert(User userEntity) {
        this.setUserId(userEntity.getUserId());
        this.setUserName(userEntity.getUserName());
        this.setUserPassword(userEntity.getPassword());
    }
}
