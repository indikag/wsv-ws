package com.jsv.rest.dal;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:24 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.persistance.Group;
import com.jsv.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupDAL {

    /**
     * Add a new group
     *
     * @param group
     * @throws Exception
     */
    public static void addGroup(Group group) throws Exception {
        if (group == null) {
            throw new IllegalArgumentException("Group is null");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            session.save(group);

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
     * Get group by group id
     *
     * @param groupId
     * @return
     * @throws Exception
     */
    public static Group getGroupByGroupId(String groupId) throws Exception {
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group id cannot be null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        Group group = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            group = session.get(Group.class, groupId);

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

        return group;
    }

    /**
     * Update an existing group
     *
     * @param group
     * @throws Exception
     */
    public static void updateGroup(Group group) throws Exception {
        if (group == null) {
            throw new IllegalArgumentException("Group is null");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            session.update(group);

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
     * Delete an existing group
     *
     * @param groupId
     * @throws Exception
     */
    public static void deleteGroup(String groupId) throws Exception {
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group id cannot be null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            Group group = session.get(Group.class, groupId);
            session.delete(group);

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
}
