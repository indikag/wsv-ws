package com.jsv.rest.dal;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:24 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.entity.ServiceEntity;
import com.jsv.rest.model.Service;
import com.jsv.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ServiceDAL {

    /**
     * Insert a new service object
     * @param service new service model(auto generated id)
     */
    public static void addService(Service service) throws IllegalArgumentException {
        service.validate();

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            ServiceEntity entity = new ServiceEntity();
            entity.setServiceId(service.getServiceId());
            entity.setJsonFile(service.getJsonFile());
            entity.setServiceName(service.getServiceName());
            entity.setServiceUrl(service.getServiceUrl());
            session.save(entity);

            transaction.commit();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        System.out.println("done");
    }

    /**
     * Update an existing service model
     * @param service new service model
     * @param updateEmptyFields if true update null and empty fields, otherwise only not null fields
     */
    public static void updateService(Service service, Boolean updateEmptyFields) throws IllegalArgumentException {
        service.validate();
        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Service existingService = session.get(Service.class, service.getServiceId());
            if (updateEmptyFields) {
                existingService.setServiceName(service.getServiceName());
                existingService.setServiceUrl(service.getServiceUrl());
                existingService.setJsonFile(service.getJsonFile());
                session.update(existingService);
            } else {
                if (service.getServiceName() != null && service.getServiceName() != "") {
                    existingService.setServiceName(service.getServiceName());
                }
                if (service.getServiceUrl() != null && service.getServiceUrl() != "") {
                    existingService.setServiceUrl(service.getServiceUrl());
                }
                if (service.getJsonFile() != null && service.getJsonFile() != "") {
                    existingService.setJsonFile(service.getJsonFile());
                }
                session.update(existingService);
            }

            session.delete(service);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Delete a service by service id
     * @param serviceId id of the service
     */
    public static void deleteService(String serviceId) throws IllegalArgumentException {
        if (serviceId == null || serviceId.isEmpty()) {
            throw new IllegalArgumentException("Service id cannot be null or empty");
        }

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Service service = session.get(Service.class, serviceId);
            session.delete(service);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Get existing service by it's id
     * @param serviceId id of the service
     * @return service model
     */
    public static Service getServiceById(String serviceId) throws IllegalArgumentException {
        if (serviceId == null || serviceId.isEmpty()) {
            throw new IllegalArgumentException("Service id cannot be null or empty");
        }

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        Service service = null;
        try {
            transaction = session.beginTransaction();
            service = session.get(Service.class, serviceId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return service;
    }

    /**
     * Get all service in the system
     */
    public static void getAllServices() {
        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List list = session.createQuery("from ServiceEntity ").list();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ServiceEntity service = ((ServiceEntity) iterator.next());
                System.out.println(service.toString());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}
