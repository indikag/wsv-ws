package com.jsv.rest;

import com.jsv.rest.persistance.Service;
import com.jsv.rest.util.Log;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */
@Path("service")
@Produces("application/json")
public class ServiceWS {

    @POST
    @Path("add")
    public void addService(Service service) {
        Log.log("Start addService");
        // Body

        Log.log("End addService");
    }

    @POST
    @Path("update")
    public void updateService() {
        Log.log("Start updateService");
        // Body

        Log.log("End updateService");
    }

    @POST
    @Path("delete")
    public void deleteService() {
        Log.log("Start deleteService");
        // Body

        Log.log("End deleteService");
    }

    @POST
    @Path("assign")
    public void assignGroup() {
        Log.log("Start assignGroup");
        // Body

        Log.log("End assignGroup");
    }
}
