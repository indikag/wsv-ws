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
@Table(name = "group", catalog = "wsv")
public class Group implements Serializable {
    private String groupId;
    private String groupName;
    private Set<Service> services = new HashSet<Service>(0);
    private Set<User> users = new HashSet<User>(0);

    public Group() {
    }

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Group(String groupId, String groupName, Set<Service> services, Set<User> users) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.services = services;
        this.users = users;
    }

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId", unique = true, nullable = false)
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(name = "groupName")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_service",
            joinColumns = {@JoinColumn(name = "groupId")},
            inverseJoinColumns = {@JoinColumn(name = "serviceId")})
    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_group",
            joinColumns = {@JoinColumn(name = "groupId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")})
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{"
                + "groupId='"
                + groupId
                + '\''
                + ", groupName='"
                + groupName
                + '\''
                + ", services="
                + services
                + ", users="
                + users
                + '}';
    }
}
