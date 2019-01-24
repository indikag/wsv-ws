package com.jsv.rest;

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
@Path("group")
@Produces("application/json")
public class GroupWS {

    @POST
    @Path("add")
    public void addGroup() {
        Log.log("Start addGroup");
        // Body

        Log.log("End addGroup");
    }

    @POST
    @Path("delete")
    public void deleteGroup() {
        Log.log("Start deleteGroup");
        // Body

        Log.log("End deleteGroup");
    }

    @POST
    @Path("update")
    public void updateGroup() {
        Log.log("Start updateGroup");
        // Body

        Log.log("End updateGroup");
    }

    @POST
    @Path("assign")
    public void assignUser() {
        Log.log("Start assignUser");
        // Body

        Log.log("End assignUser");
    }
}
