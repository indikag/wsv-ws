package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:16 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class GroupServiceMap {
    private String mapId;
    private String groupId;
    private String serviceId;

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override public String toString() {
        return "GroupServiceMap{" + "mapId='" + mapId + '\'' + ", groupId='" + groupId + '\'' + ", serviceId='"
                + serviceId + '\'' + '}';
    }
}
