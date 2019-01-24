package com.jsv.rest.persistance;
/*
 * User: Indika Gunawardana
 * Date: 1/23/19
 * Time: 5:03 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", catalog = "wsv")
public class User implements Serializable {
    private String userId;
    private String password;
    private String userName;
    private Set<Group> groups = new HashSet<Group>(0);

    public User() {
    }

    public User(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public User(String userId, String password, String userName, Set<Group> groups) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.groups = groups;
    }

    @Id
    @Column(name = "userId", unique = true, nullable = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_group",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "groupId")})
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId='"
                + userId
                + '\''
                + ", password='"
                + password
                + '\''
                + ", userName='"
                + userName
                + '\''
                + ", groups="
                + groups.size()
                + '}';
    }
}
