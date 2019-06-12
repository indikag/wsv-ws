package com.jsv.rest.persistance;
/*
 * User: Indika Gunawardana
 * Date: 1/23/19
 * Time: 5:03 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "service", catalog = "wsv")
public class Service implements Serializable {
    private String serviceId;
    private String jsonFile;
    private String serviceName;
    private String serviceUrl;
    private Boolean published;
    private String token;
    private Set<Group> groups = new HashSet<Group>(0);

    public Service() {
    }

    public Service(String serviceId, String jsonFile, String serviceName, String serviceUrl, Boolean published) {
        this.serviceId = serviceId;
        this.jsonFile = jsonFile;
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.published = published;
    }

    public Service(
            String serviceId, String jsonFile, String serviceName, String serviceUrl, Set<Group> groups) {
        this.serviceId = serviceId;
        this.jsonFile = jsonFile;
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.groups = groups;
    }

    @Id
    @Column(name = "serviceId", unique = true, nullable = false)
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Column(name = "jsonFile")
    public String getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Column(name = "serviceName")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Column(name = "serviceUrl")
    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    @Column(name = "published")
    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    //@Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "group_service",
            joinColumns = {@JoinColumn(name = "serviceId")},
            inverseJoinColumns = {@JoinColumn(name = "groupId")})
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId='" + serviceId + '\'' +
                ", jsonFile='" + jsonFile + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", published=" + published +
                ", token=" + token +
                ", groups=" + groupString(groups) +
                '}';
    }

    private String groupString(Set<Group> groups) {
        if (groups == null) {
            return "null";
        }
        String out = "";
        Iterator<Group> iterator = groups.iterator();
        while (iterator.hasNext()) {
            out += iterator.next().toString();
        }

        return out;
    }
}
