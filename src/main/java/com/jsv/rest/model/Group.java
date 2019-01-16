package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:14 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.entity.GroupEntity;

public class Group extends GroupEntity {
    /**
     * Validate compulsory parameter of the model
     *
     * @throws IllegalArgumentException
     */
    public void validate() throws IllegalArgumentException {
        if (this.getGroupId() == null || this.getGroupId().isEmpty()) {
            throw new IllegalArgumentException("Group ID cannot be null or empty");
        }
    }

    /**
     * Convert group entity to group model
     *
     * @param entity
     */
    public void convert(GroupEntity entity) {
        this.setGroupId(entity.getGroupId());
        this.setGroupName(entity.getGroupName());
    }
}
