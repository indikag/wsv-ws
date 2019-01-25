package com.jsv.rest;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.persistance.User;
import com.jsv.rest.util.Log;
import com.jsv.rest.util.Response;
import com.jsv.rest.util.Status;

import javax.ws.rs.*;
import java.util.List;

@Path("user")
@Produces("application/json")
public class UserWS {
    private Response response = new Response();

    @GET
    @Path("/get")
    public Response getUserByUserId(@QueryParam("id") String id) {
        Log.log("Start getUserByUserId");
        // Body

        Log.log("End getUserByUserId");
        return response;
    }

    @POST
    @Path("/login")
    public Response login(User user) {
        Log.log("Start login " + user.toString());
        //Body
        List userList;
        try {
            userList = UserDAL.login(user.getUserName(), user.getPassword());
            if (userList != null && userList.size() > 0) {
                response.setStatus(Status.SUCCESS);
                response.setPayload(true);
            } else {
                response.setStatus(Status.APPLICATION_ERROR);
                response.setPayload(false);
            }
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(false);
        }

        Log.log("End login " + response.toString());
        return response;
    }

    @POST
    @Path("/add")
    public Response addUser(User user) throws IllegalArgumentException {
        Log.log("Start add");
        // Body

        Log.log("End add");
        return response;
    }

    @POST
    @Path("/assign")
    public Response joinGroup() {
        Log.log("Start assignToGroup");
        // Body

        Log.log("End assignToGroup");
        return response;
    }

    @POST
    @Path("/resign")
    public void leaveGroup() {
        Log.log("Start assignToGroup");
        // Body

        Log.log("End assignToGroup");
    }

    @POST
    @Path("/update")
    public void updateUser() {
        Log.log("Start updateUser");
        // Body

        Log.log("End updateUser");
    }
}
