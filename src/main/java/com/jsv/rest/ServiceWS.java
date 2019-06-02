package com.jsv.rest;

import com.jsv.rest.dal.GroupDAL;
import com.jsv.rest.dal.ServiceDAL;
import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.model.ServiceModel;
import com.jsv.rest.persistance.Group;
import com.jsv.rest.persistance.Service;
import com.jsv.rest.persistance.User;
import com.jsv.rest.util.Log;
import com.jsv.rest.util.Response;
import com.jsv.rest.util.Status;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public javax.ws.rs.core.Response getServiceByGroupId(@QueryParam("id") String id) {
        Log.log("Start getServiceByUserId");
        try {
            ArrayList<ServiceModel> list = new ArrayList<ServiceModel>();
            Set<Service> services = GroupDAL.getGroupByGroupId(id).getServices();
            for (Service s :
                    services) {
                ServiceModel model = new ServiceModel();
                model.convert(s);
                list.add(model);
            }
            response.setStatus(Status.SUCCESS);
            response.setPayload(list);
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(null);
        }
        Log.log("End getServiceByUserId=======" + response);
        return response.build();
    }

    @POST
    @Path("add")
    public javax.ws.rs.core.Response addService(Service service, @QueryParam("groupId") String groupId) {
        Log.log("Start addService");
        Log.log("User Id " + groupId);
        if (service == null) {
            System.out.println("Service is null");
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload("Empty request");
        }
        if (groupId == null || groupId.isEmpty()) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload("Group id is null or empty");
        }

        // Body
        try {
            //Assigning user group information
            Group group = GroupDAL.getGroupByGroupId(groupId);
            Set<Group> groups = new HashSet<Group>();
            groups.add(group);
            service.setGroups(groups);

            //Updating the service information
            ServiceDAL.addService(service);
            response.setStatus(Status.SUCCESS);
            response.setPayload(true);
        } catch (Exception e) {
            //e.printStackTrace();
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(e.getMessage());
        }
        Log.log("End addService");
        return response.build();
    }

    @GET
    @Path("getService")
    public javax.ws.rs.core.Response getServiceByServiceId(@QueryParam("id") String id) {
        Log.log("Start getServiceByUserId");
        try {
            Service service = ServiceDAL.getServiceByServiceId(id);
            response.setStatus(Status.SUCCESS);
            response.setPayload(service);
        } catch (Exception e) {
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(null);
        }
        Log.log("End getServiceByUserId=======" + response);
        return response.build();
    }

    @POST
    @Path("update")
    public void updateService() {
        Log.log("Start updateService");
        // Body

        Log.log("End updateService");
    }

    @GET
    @Path("delete")
    public javax.ws.rs.core.Response deleteService(@QueryParam("id") String id) {
        System.out.println("==============id (delete)=======" + id);
        Log.log("Start deleteService");
        // Body
        try {
            ServiceDAL.deleteService(id);
            response.setStatus(Status.SUCCESS);
            response.setPayload(true);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(false);
        }

        Log.log("End deleteService");
        return response.build();
    }

    @GET
    @Path("publish")
    public void publish(@QueryParam("id") String id) {
        Log.log("Start publish");
        // Body
        try {
            ServiceDAL.publishUnpublishService(id, true);
            response.setStatus(Status.SUCCESS);
            response.setPayload(true);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(false);
        }

        Log.log("End publish");
    }

    @GET
    @Path("unpublish")
    public void unpublish(@QueryParam("id") String id) {
        Log.log("Start unpublish");
        // Body
        try {
            ServiceDAL.publishUnpublishService(id, false);
            response.setStatus(Status.SUCCESS);
            response.setPayload(true);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(Status.APPLICATION_ERROR);
            response.setPayload(false);
        }
        Log.log("End unpublish");
    }

    @POST
    @Path("assign")
    public void assignGroup() {
        Log.log("Start assignGroup");
        // Body

        Log.log("End assignGroup");
    }
}
