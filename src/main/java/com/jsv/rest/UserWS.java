package com.jsv.rest;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("user") public class UserWS {
    @GET @Path("/getUserByUserId") @Produces("application/json") public User getUserByUserId() {
        return null;
    }
}
