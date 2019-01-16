package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:12 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.entity.UserEntity;

public class User extends UserEntity {
    /**
     * Validate compulsory parameter of the model
     *
     * @throws IllegalArgumentException
     */
    public void validate() throws IllegalArgumentException {
        if (this.getUserId() == null || this.getUserId().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
    }
}
