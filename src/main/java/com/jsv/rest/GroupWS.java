package com.jsv.rest;

import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.persistance.Group;
import com.jsv.rest.util.Log;
import com.jsv.rest.util.Response;
import com.jsv.rest.util.Status;

import javax.ws.rs.*;
import java.util.Set;

/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */
@Path("group")
@Produces("application/json")
public class GroupWS {
    private Response response = new Response();

    @GET
    @Path("/get")
    public javax.ws.rs.core.Response getGrupsByUserId(@QueryParam("id") String id) {
        Log.log("Start getUserByUserId");
        // Body
        try {
            Set<Group> user = UserDAL.getUser(id).getGroups();
            response.setStatus(Status.SUCCESS);
            response.setPayload(user);
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(null);
        }

        Log.log("End getUserByUserId");
        return response.build();
    }

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
