package com.jsv.rest.entity;
/*
 * User: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:42 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity @Table(name = "service", schema = "wsv", catalog = "") public class ServiceEntity {
    private String serviceId;
    private String serviceName;
    private String serviceUrl;
    private String jsonFile;

    @Id
    @Column(name = "serviceId")
    @GeneratedValue(generator = "id-gen")
    @GenericGenerator(name = "id-gen", strategy = "com.jsv.rest.util.IdGenerator")
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Basic @Column(name = "serviceName") public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic @Column(name = "serviceUrl") public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    @Basic @Column(name = "jsonFile") public String getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceEntity that = (ServiceEntity) o;

        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null)
            return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null)
            return false;
        if (serviceUrl != null ? !serviceUrl.equals(that.serviceUrl) : that.serviceUrl != null)
            return false;
        if (jsonFile != null ? !jsonFile.equals(that.jsonFile) : that.jsonFile != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (serviceUrl != null ? serviceUrl.hashCode() : 0);
        result = 31 * result + (jsonFile != null ? jsonFile.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "ServiceEntity{" + "serviceId='" + serviceId + '\'' + ", serviceName='" + serviceName + '\''
                + ", serviceUrl='" + serviceUrl + '\'' + ", jsonFile='" + jsonFile + '\'' + '}';
    }
}
