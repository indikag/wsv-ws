package com.jsv.rest;
/*
 * User: Indika Gunawardana
 * Date: 12/25/18
 * Time: 6:04 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//http://localhost:8080/jsv/rest/hello
@Path("/hello")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String helloResource() {
        return "Hello! It's "+new Date();
    }
}
