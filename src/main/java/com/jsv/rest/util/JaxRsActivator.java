package com.jsv.rest.util;
/*
 * UserEntity: Indika Gunawardana
 * Date: 12/25/18
 * Time: 6:05 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

import com.jsv.rest.GroupWS;
import com.jsv.rest.ServiceWS;
import com.jsv.rest.UserWS;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private HashSet<Class<?>> classes = new HashSet<Class<?>>();

    public JaxRsActivator() {
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        singletons.add(corsFilter);

        classes.add(UserWS.class);
        classes.add(ServiceWS.class);
        classes.add(GroupWS.class);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public HashSet<Class<?>> getClasses() {
        return classes;
    }
}
