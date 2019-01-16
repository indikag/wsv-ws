package com.jsv.rest.util;
/*
 * User: Indika Gunawardana
 * Date: 1/6/19
 * Time: 2:32 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator {

    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        return UUID.randomUUID().toString();
    }
}
