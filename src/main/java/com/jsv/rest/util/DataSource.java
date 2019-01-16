package com.jsv.rest.util;
/*
 * User: Indika Gunawardana
 * Date: 1/5/19
 * Time: 8:16 PM
 * Copyright(c) 2018 AXIS, LLC.
 */

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/wsv";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "12345678";
    private static DataSource datasource;
    private static final BasicDataSource basicDataSource;

    static {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(JDBC_DRIVER);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(DB_URL);
    }

    public static BasicDataSource getInstance() {
        return basicDataSource;
    }
}
