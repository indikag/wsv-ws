package com.jsv.rest;

import com.jsv.rest.dal.GroupDAL;
import com.jsv.rest.dal.ServiceDAL;
import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.persistance.Group;
import com.jsv.rest.persistance.Service;
import com.jsv.rest.persistance.User;
import com.jsv.rest.util.ConfigProperty;
import com.jsv.rest.util.Constants;
import com.jsv.rest.util.IdGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;

/*
 * UserEntity: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:41 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Main {
    static String userId = "1";
    static String groupId = "1b108fb4-2ed6-45d9-ba2c-1849f474d67f";
    static String serviceId = "82b8bd37-6c5c-4203-8239-4ed8e73f9c86";

    public static void main(final String[] args) throws Exception {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.ALL); //or whatever level you need

        // addUser();
        // getUser();
        // addGroup();
        // getGroup();
        //addService();
        //getService();
        //assign();
        //resign();
        //addSampleServicesToUser();
        //getServicesByUserId();
        //getUserByUserId();
        //getServicesForGroup();
        //checkSet();
        //getGroupsByUserId();
        //deleteService("1-s");
        //publish();

        //updateService();

        ConfigProperty configProperty = ConfigProperty.getInstance();
        String a = configProperty.readProperty(Constants.ConfigProperties.HOST_URL.getValue());
        System.out.println(a);
    }

    static void updateService() {
        try {
            //Service s = ServiceDAL.getServiceByServiceId("8bf536fd-0071-45b9-9a04-6f2579503dee");
            //s.setServiceName("Campus1");

            Group group = GroupDAL.getGroupByGroupId("1-g");
            Set<Group> gSet = new HashSet<Group>();
            gSet.add(group);

            Service s2 = new Service();
            s2.setServiceName("Houston bay 4");
            s2.setGroups(gSet);
            s2.setServiceId("ffb6af07-d3fc-4599-bf14-fb5ee3669e1a");
            s2.setPublished(true);
            s2.setJsonFile("json file");
            s2.setServiceUrl("http://wwww/google.lk");

            ServiceDAL.updateService(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addService() {
        Service service = new Service();
        service.setServiceId(IdGenerator.generate());
        service.setJsonFile("path to the file");
        service.setServiceName("test_service_1");
        service.setServiceUrl("http://localhost:8080/wsv");
        service.setPublished(false);

        Group g1 = new Group("1-g", "group-1", null, null);
        service.getGroups().add(g1);

        System.out.println(service.toString());
        try {
            ServiceDAL.addService(service);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    static void publish() {
        try {
            ServiceDAL.publishUnpublishService("1-s", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteService(String serviceId) {
        try {
            ServiceDAL.deleteService(serviceId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getGroupsByUserId() {
        try {
            Set<Group> user = UserDAL.getUser(userId).getGroups();
            System.out.println(user.size());
            for (Group g :
                    user) {
                System.out.println(g.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getServicesForGroup() throws Exception {
        Group group = GroupDAL.getGroupByGroupId(groupId);
        Set<Service> services = group.getServices();
        for (Service s :
                services) {
            System.out.println(s.toString());
        }
    }

    static void checkSet() {
        Set set = new HashSet();
        set.add("s");
        set.add("ss");
        set.add("sss");

        System.out.println(Arrays.toString(set.toArray()));
    }


    static void addSampleServicesToUser() {
        ArrayList<String> idList = new ArrayList<String>();
        for (int a = 0; a < 5; a++) {
            String id = IdGenerator.generate();
            idList.add(id);

            addService(id, a);
        }
    }

    private static void addService(String id, int index) {
        Service service = new Service();
        service.setServiceId(id);
        service.setJsonFile("path to the file");
        service.setServiceName("test_service_1" + index);
        service.setServiceUrl("http://localhost:8080/wsv");

        try {
            ServiceDAL.addService(service);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    static void resign() {
        try {
            UserDAL.resignFromGroup(userId, groupId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void assign() {
        try {
            UserDAL.assignToGroup(userId, groupId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    COMPLETED BASIC OPERATIONS OF ALL CLASSES
     */

    private static void getService() {
        try {
            Service service = ServiceDAL.getServiceByServiceId(serviceId);
            System.out.println(service.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getGroup() {
        try {
            Group group = GroupDAL.getGroupByGroupId(groupId);
            System.out.println(group.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addGroup() {
        Group group = new Group();
        group.setGroupName("group_01");
        group.setGroupId(IdGenerator.generate());
        try {
            GroupDAL.addGroup(group);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static User getUser() {
        User user = null;
        try {
            user = UserDAL.getUser(userId);
            System.out.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    private static void addUser() {
        User user = new User();
        user.setUserId(IdGenerator.generate());
        user.setUserName("test_01");
        user.setPassword("hello_123");
        try {
            UserDAL.addUser(user);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
