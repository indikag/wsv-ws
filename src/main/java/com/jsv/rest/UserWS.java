package com.jsv.rest;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.model.User;
import com.jsv.rest.util.Log;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("user") @Produces("application/json") public class UserWS {
    @GET @Path("/get") public User getUserByUserId() {
        Log.log("Start getUserByUserId");
        //Body

        Log.log("End getUserByUserId");
        return null;
    }

    @POST @Path("/login") public boolean login(User user) {
        Log.log("Start login");
        boolean success = false;
        //Body
        Log.log(user.toString());
        List userList = UserDAL.getUserByUserNameAndPassword(user);
        Log.log("size=" + userList.size());
        if (userList != null && !userList.isEmpty()) {
            success = true;
        }

        Log.log("End login");
        return success;
    }

    @POST @Path("/add") public void addUser() {
        Log.log("Start add");
        //Body

        Log.log("End add");
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
