package com.jsv.rest;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.model.UserModel;
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
    public javax.ws.rs.core.Response getUserByUserId(@QueryParam("id") String id) {
        Log.log("Start getUserByUserId");
        // Body
        try {
            User user = UserDAL.getUser(id);
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
    @Path("/login")
    public javax.ws.rs.core.Response login(User user) {
        Log.log("Start login " + user.toString());
        //Body
        try {
            List<User> userList = UserDAL.login(user.getUserName(), user.getPassword());
            if (userList != null && userList.size() > 0) {
                User user_ = userList.get(0);
                UserModel model = new UserModel();
                model.convert(user_);
                response.setStatus(Status.SUCCESS);
                response.setPayload(model.getUserId());
            } else {
                response.setStatus(Status.APPLICATION_ERROR);
                response.setPayload(false);
            }
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(false);
        }

        Log.log("End login " + response.toString());
        return response.build();
    }

    @POST
    @Path("/add")
    public javax.ws.rs.core.Response addUser(User user) throws IllegalArgumentException {
        Log.log("Start add");
        // Body

        Log.log("End add");
        return response.build();
    }

    @POST
    @Path("/assign")
    public javax.ws.rs.core.Response joinGroup() {
        Log.log("Start assignToGroup");
        // Body

        Log.log("End assignToGroup");
        return response.build();
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
