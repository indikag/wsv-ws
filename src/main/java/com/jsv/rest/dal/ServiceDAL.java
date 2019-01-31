package com.jsv.rest.dal;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:24 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.persistance.Service;
import com.jsv.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceDAL {
    /**
     * Add a new user
     *
     * @param service
     * @throws Exception
     */
    public static void addService(Service service) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("Service is null");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            session.save(service);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Get service by service id
     *
     * @param serviceId
     * @return
     * @throws Exception
     */
    public static Service getServiceByServiceId(String serviceId) throws Exception {
        if (serviceId == null || serviceId.isEmpty()) {
            throw new IllegalArgumentException("Service id cannot be null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        Service service = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            service = session.get(Service.class, serviceId);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return service;
    }

    /**
     * Update an existing user
     *
     * @param service
     * @throws Exception
     */
    public static void updateService(Service service) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("Service is null");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            session.update(service);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Delete an existing user
     *
     * @param serviceId
     * @throws Exception
     */
    public static void deleteService(String serviceId) throws Exception {
        if (serviceId == null || serviceId.isEmpty()) {
            throw new IllegalArgumentException("Service id cannot be null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            Service service = session.get(Service.class, serviceId);
            session.delete(service);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Get all services for a user
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public static List<Service> getServicesByUserId(String userId) throws Exception {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User id is null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        List list = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            String hql = "";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
