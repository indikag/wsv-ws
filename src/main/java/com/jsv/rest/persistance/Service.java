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
@Table(name = "service", catalog = "wsv")
public class Service implements Serializable {
    private String serviceId;
    private String jsonFile;
    private String serviceName;
    private String serviceUrl;
    private Set<Group> groups = new HashSet<Group>(0);

    public Service() {
    }

    public Service(String serviceId, String jsonFile, String serviceName, String serviceUrl) {
        this.serviceId = serviceId;
        this.jsonFile = jsonFile;
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
        return "Service{"
                + "serviceId='"
                + serviceId
                + '\''
                + ", jsonFile='"
                + jsonFile
                + '\''
                + ", serviceName='"
                + serviceName
                + '\''
                + ", serviceUrl='"
                + serviceUrl
                + '\''
                + ", groups="
                + groups
                + '}';
    }
}
