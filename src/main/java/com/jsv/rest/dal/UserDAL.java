package com.jsv.rest.dal;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:24 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.persistance.Group;
import com.jsv.rest.persistance.Service;
import com.jsv.rest.persistance.User;
import com.jsv.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAL {
    public static void common(User user) throws Exception {
        if (user == null) {
            throw new IllegalArgumentException("User model is null");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();
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
     * Adding a new user
     *
     * @param user
     */
    public static void addUser(User user) throws Exception {
        if (user == null) {
            throw new IllegalArgumentException("User model is null");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();
            session.save(user);
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
     * Get user by user id
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public static User getUser(String userId) throws Exception {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User id cannot be null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        User user = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, userId);
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

        return user;
    }

    /**
     * Get user by user name and password
     *
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public static List login(String userName, String password) throws Exception {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is null or empty");
        }

        Session session = null;
        Transaction transaction = null;
        List<Service> list = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();
            String hql = "From User U WHERE U.userName=:userName AND U.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("userName", userName);
            query.setParameter("password", password);
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

    /**
     * Assigning a user to a group
     *
     * @param userId
     * @param groupId
     * @throws Exception
     */
    public static void assignToGroup(String userId, String groupId) throws Exception {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User Id cannot be null or empty");
        }
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group Id is null or empty");
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user == null) {
                throw new Exception("Invalid user Id");
            }
            Group group = session.get(Group.class, groupId);
            if (group == null) {
                throw new Exception("Invalid group Id");
            }

            Set list = new HashSet();
            list.add(group);
            user.setGroups(list);
            session.save(user);

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
     * Resign a user from a group
     *
     * @param userId
     * @param groupId
     * @throws Exception
     */
    public static void resignFromGroup(String userId, String groupId) throws Exception {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User Id cannot be null or empty");
        }
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group Id is null or empty");
        }
        Session session = null;
        Transaction transaction = null;

        try {
            session = SessionUtil.getSession();
            transaction = session.beginTransaction();

            User user = session.get(User.class, userId);
            if (user == null) {
                throw new IllegalArgumentException("User id is not valid");
            }
            Group group = session.get(Group.class, groupId);
            if (group == null) {
                throw new IllegalArgumentException("Group id is not valid");
            }

            // Get the users current group list and remove the item
            Set<Group> groups = user.getGroups();
            groups.remove(group);
            // set new list
            user.setGroups(groups);
            session.update(user);

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
