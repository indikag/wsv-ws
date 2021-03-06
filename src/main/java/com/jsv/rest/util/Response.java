package com.jsv.rest.util;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/21/19
 * Time: 4:03 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Response {
    private Status status;
    private Object payload;

    public Response() {
    }

    public Response(Status status, Object payload) {
        this.status = status;
        this.payload = payload;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public javax.ws.rs.core.Response build() {
        javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.ok(this);
        builder.status(this.status.getCode());

        return builder.build();
    }

    @Override
    public String toString() {
        return "Response{" + "status=" + status + ", payload=" + payload + '}';
    }

}
