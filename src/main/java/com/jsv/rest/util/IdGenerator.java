package com.jsv.rest.util;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/6/19
 * Time: 2:32 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import org.hibernate.HibernateException;

import java.util.UUID;

public class IdGenerator {

    /**
     * Generate an unique id
     *
     * @return
     * @throws HibernateException
     */
    public static synchronized String generate() throws HibernateException {
        return UUID.randomUUID().toString();
    }
}
