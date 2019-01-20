package com.jsv.rest;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.model.User;
import com.jsv.rest.util.IdGenerator;
import com.jsv.rest.util.Log;
import com.jsv.rest.util.Response;
import com.jsv.rest.util.Status;

import javax.ws.rs.*;
import java.util.List;

@Path("user") @Produces("application/json") public class UserWS {
    private Response response = new Response();

    @GET @Path("/get") public Response getUserByUserId(@QueryParam("id") String id) {
        Log.log("Start getUserByUserId");
        //Body
        Log.log("id = " + id);
        User user = null;
        try {
            user = UserDAL.getUserByUserId(id);
            response.setPayload(user);
            response.setStatus(Status.SUCCESS);
        } catch (Exception e) {
            response.setPayload(user);
            response.setStatus(Status.APPLICATION_ERROR);
        }

        Log.log("End getUserByUserId");
        return response;
    }

    @POST @Path("/login") public Response login(User user) {
        Log.log("Start login");
        boolean success = false;
        //Body
        Log.log(user.toString());
        List userList = null;
        try {
            userList = UserDAL.getUserByUserNameAndPassword(user);
            Log.log("size=" + userList.size());
            if (userList != null && !userList.isEmpty()) {
                response.setStatus(Status.SUCCESS);
                response.setPayload(true);
            } else {
                response.setStatus(Status.SUCCESS);
                response.setPayload(false);
            }
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(false);
        }

        Log.log("End login");
        return response;
    }

    @POST @Path("/add") public Response addUser(User user) throws IllegalArgumentException {
        Log.log("Start add");
        //Body
        if (user == null) {
            throw new IllegalArgumentException("User model is null");
        }
        Log.log(user.toString());

        try {
            user.setUserId(IdGenerator.generate());
            UserDAL.addUser(user);
            response.setStatus(Status.SUCCESS);
            response.setPayload(true);
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(true);
        }

        Log.log("End add");
        return response;
    }

    @POST @Path("/assign") public void assignToAGroup() {
        Log.log("Start assignToGroup");
        //Body

        Log.log("End assignToGroup");
    }

    @POST @Path("/update") public void updateUser() {
        Log.log("Start updateUser");
        //Body

        Log.log("End updateUser");
    }
}
