package com.jsv.rest.dal;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:24 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.entity.UserEntity;
import com.jsv.rest.model.User;
import com.jsv.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAL {
    /**
     * Adding a new user model
     *
     * @param user user model
     * @throws IllegalArgumentException
     */
    public static void addUser(User user) throws IllegalArgumentException {
        user.validate();

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(user.getUserId());
            userEntity.setPassword(user.getPassword());
            userEntity.setUserName(user.getUserName());

            session.save(userEntity);
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
    }

    /**
     * Update an existing user
     *
     * @param user
     * @param updateEmptyFields
     * @throws IllegalArgumentException
     */
    public static void updateUser(User user, Boolean updateEmptyFields) throws IllegalArgumentException {
        user.validate();
        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User existingUser = session.get(User.class, user.getUserId());
            if (updateEmptyFields) {
                existingUser.setPassword(user.getPassword());
                existingUser.setUserName(user.getUserName());

                session.update(existingUser);
            } else {
                if (user.getUserName() != null && user.getUserName() != "") {
                    existingUser.setUserName(user.getUserName());
                }
                if (user.getPassword() != null && user.getPassword() != "") {
                    existingUser.setPassword(user.getPassword());
                }
                session.update(existingUser);
            }

            session.delete(user);
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
     * Delete a user by user id
     *
     * @param userId id of the user
     * @throws IllegalArgumentException
     */
    public static void deleteUser(String userId) throws IllegalArgumentException {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User id cannot be null or empty");
        }

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            session.delete(user);
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
     * Get user by user id
     *
     * @param userId id of the user
     * @return user model
     * @throws IllegalArgumentException user id is null or empty
     */
    public static User getUserByUserId(String userId) throws IllegalArgumentException {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User id cannot be null or empty");
        }

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            user = session.get(User.class, userId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return user;
    }

    /**
     * Gets all users
     *
     * @return list or user models
     */
    public static ArrayList<User> getAllUsers() {
        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        ArrayList<User> userList = null;
        try {
            transaction = session.beginTransaction();
            List list = session.createQuery("from UserEntity ").list();
            Iterator iterator = list.iterator();
            userList = new ArrayList<User>();
            while (iterator.hasNext()) {
                UserEntity entity = ((UserEntity) iterator.next());
                User user = new User();
                user.convert(entity);
                userList.add(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return userList;
    }
}
