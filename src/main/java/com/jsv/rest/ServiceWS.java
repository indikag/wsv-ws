package com.jsv.rest;

import com.jsv.rest.dal.ServiceDAL;
import com.jsv.rest.persistance.Service;
import com.jsv.rest.util.Log;
import com.jsv.rest.util.Response;
import com.jsv.rest.util.Status;

import javax.ws.rs.*;
import java.util.List;

/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:20 PM
 * Copyright(c) 2018 AXIS, LLC.
 */
@Path("service")
@Produces("application/json")
public class ServiceWS {
    private Response response = new Response();

    @GET
    @Path("get")
    public javax.ws.rs.core.Response getServiceByUserId(@QueryParam("id") String id) {
        Log.log("Start getServiceByUserId");
        try {
            List<Service> serviceList = ServiceDAL.getServicesByUserId(id);
            response.setStatus(Status.SUCCESS);
            response.setPayload(serviceList);
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(null);
        }
        Log.log("End getServiceByUserId=======" + response);
        return response.build();
    }

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
