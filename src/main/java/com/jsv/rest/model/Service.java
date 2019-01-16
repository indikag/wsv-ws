package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:14 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.entity.ServiceEntity;

public class Service extends ServiceEntity {

    /**
     * Validate compulsory parameter of the model
     *
     * @throws IllegalArgumentException
     */
    public void validate() throws IllegalArgumentException {
        if (this.getServiceId() == null || this.getServiceId().isEmpty()) {
            throw new IllegalArgumentException("Service ID cannot be null or empty");
        }
    }

    /**
     * Convert service entity to service model
     *
     * @param entity
     */
    public void convert(ServiceEntity entity) {
        this.setServiceId(entity.getServiceId());
        this.setServiceName(entity.getServiceName());
        this.setServiceUrl(entity.getServiceUrl());
        this.setJsonFile(entity.getJsonFile());
    }
}
