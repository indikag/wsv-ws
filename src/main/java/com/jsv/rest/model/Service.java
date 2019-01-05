package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:14 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Service {
    private String serviceId;
    private String serviceName;
    private String serviceUrl;
    private String jsonFile;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override public String toString() {
        return "Service{" + "serviceId='" + serviceId + '\'' + ", serviceName='" + serviceName + '\'' + ", serviceUrl='"
                + serviceUrl + '\'' + ", jsonFile='" + jsonFile + '\'' + '}';
    }
}
