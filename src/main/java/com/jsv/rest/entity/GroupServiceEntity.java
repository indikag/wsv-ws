package com.jsv.rest.entity;
/*
 * User: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:42 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "group_service", schema = "wsv", catalog = "") public class GroupServiceEntity {
    private String mapId;

    @Id @Column(name = "mapId") public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GroupServiceEntity that = (GroupServiceEntity) o;

        if (mapId != null ? !mapId.equals(that.mapId) : that.mapId != null)
            return false;

        return true;
    }

    @Override public int hashCode() {
        return mapId != null ? mapId.hashCode() : 0;
    }
}
