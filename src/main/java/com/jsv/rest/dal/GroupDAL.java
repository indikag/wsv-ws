package com.jsv.rest.dal;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 5:24 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.entity.GroupEntity;
import com.jsv.rest.model.Group;
import com.jsv.rest.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupDAL {
    /**
     * Adding a new group model
     *
     * @param group group model
     * @throws IllegalArgumentException group model contains null or empty fields
     */
    public static void addGroup(Group group) throws IllegalArgumentException {
        group.validate();

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setGroupId(group.getGroupId());
            groupEntity.setGroupName(group.getGroupName());

            session.save(groupEntity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Update an existing group
     *
     * @param group             new group mode;
     * @param updateEmptyFields
     * @throws IllegalArgumentException Group model is not valid
     */
    public static void updateGroup(Group group, Boolean updateEmptyFields) throws IllegalArgumentException {
        group.validate();
        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Group existingUser = session.get(Group.class, group.getGroupId());
            if (updateEmptyFields) {
                existingUser.setGroupName(group.getGroupName());
                existingUser.setGroupId(group.getGroupId());

                session.update(existingUser);
            } else {
                if (group.getGroupId() != null && group.getGroupId() != "") {
                    existingUser.setGroupId(group.getGroupId());
                }
                if (group.getGroupName() != null && group.getGroupName() != "") {
                    existingUser.setGroupName(group.getGroupName());
                }
                session.update(existingUser);
            }

            session.delete(group);
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
     * Delete a group by user id
     *
     * @param groupId id of the group
     * @throws IllegalArgumentException group id is null or empty
     */
    public static void deleteGroup(String groupId) throws IllegalArgumentException {
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group id cannot be null or empty");
        }

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Group group = session.get(Group.class, groupId);
            session.delete(group);
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
     * @param groupId id of the group
     * @return group model
     * @throws IllegalArgumentException group id is null or empty
     */
    public static Group getGroupByGroupId(String groupId) throws IllegalArgumentException {
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("Group id cannot be null or empty");
        }

        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        Group group = null;
        try {
            transaction = session.beginTransaction();
            group = session.get(Group.class, groupId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return group;
    }

    /**
     * Gets all groups
     *
     * @return list or group models
     */
    public static ArrayList<Group> getAllGroups() {
        Session session = SessionUtil.getSession();
        Transaction transaction = null;
        ArrayList<Group> groupList = null;
        try {
            transaction = session.beginTransaction();
            List list = session.createQuery("from GroupEntity ").list();
            Iterator iterator = list.iterator();
            groupList = new ArrayList<Group>();
            while (iterator.hasNext()) {
                GroupEntity entity = ((GroupEntity) iterator.next());
                Group group = new Group();
                group.convert(entity);
                groupList.add(group);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return groupList;
    }
}
