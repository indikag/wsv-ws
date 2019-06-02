package com.jsv.rest;

import com.jsv.rest.dal.GroupDAL;
import com.jsv.rest.dal.ServiceDAL;
import com.jsv.rest.dal.UserDAL;
import com.jsv.rest.persistance.Group;
import com.jsv.rest.persistance.Service;
import com.jsv.rest.persistance.User;
import com.jsv.rest.util.IdGenerator;

import java.util.*;

/*
 * UserEntity: Indika Gunawardana
 * Date: 1/6/19
 * Time: 4:41 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Main {
    static String userId = "602d29e8-b331-4840-b53f-28676469b940";
    static String groupId = "1b108fb4-2ed6-45d9-ba2c-1849f474d67f";
    static String serviceId = "0e30d539-b459-4635-8400-fefa0b61fde9";

    public static void main(final String[] args) throws Exception {
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
        getGroupsByUserId();
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
        for (Service s:
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
        for (int a =0; a< 5; a++) {
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

    private static void addService() {
        Service service = new Service();
        service.setServiceId(IdGenerator.generate());
        service.setJsonFile("path to the file");
        service.setServiceName("test_service_1");
        service.setServiceUrl("http://localhost:8080/wsv");

        try {
            ServiceDAL.addService(service);
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
