package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 2/5/19
 * Time: 6:47 PM
 * Copyright(c) 2018 AXIS, LLC.
 */


import com.jsv.rest.persistance.Service;

public class ServiceModel {
    private String serviceId;
    private String serviceName;
    private String serviceUrl;
    private String jsonFile;
    private Boolean published;

    public ServiceModel() {
    }

    public ServiceModel(String serviceId, String serviceName, String serviceUrl, String jsonFile, Boolean published) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceUrl = serviceUrl;
        this.jsonFile = jsonFile;
        this.published = published;
    }

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

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "ServiceModel{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", jsonFile='" + jsonFile + '\'' +
                ", published=" + published +
                '}';
    }

    public void convert(Service serviceEntity) {
        this.setServiceId(serviceEntity.getServiceId());
        this.setServiceName(serviceEntity.getServiceName());
        this.setServiceUrl(serviceEntity.getServiceUrl());
        this.setJsonFile(serviceEntity.getJsonFile());
        this.setPublished(serviceEntity.getPublished());
    }
}
