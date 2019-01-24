package com.jsv.rest.util;
/*
 * UserEntity: Indika Gunawardana
 * Date: 1/21/19
 * Time: 4:04 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Status {
    public static final Status SUCCESS = new Status(200, "Success", "Action completed Successfully.");
    public static final Status SERVER_ERROR =
            new Status(500, "Server error", "Internal Server error occurred");
    public static final Status APPLICATION_ERROR =
            new Status(600, "fail", "the request sent by the client is fail");
    public static final Status UNKNOWN =
            new Status(400, "Unknown HTTP Status Code", "Unknown or unsupported HTTP status code");
    public static final Status UNAUTHORIZED =
            new Status(401, "Unknown HTTP Status Code", "Unknown or unsupported HTTP status code");
    public static final Status SESSION_TIMEOUT =
            new Status(440, "Session Timeout", "Your Session has expired please login again.");
    public static final Status PASSWORD_EXPIRE =
            new Status(541, "expired password", "Password Expired, need to reset password");
    public static final Status GENERATE_KEY =
            new Status(
                    542,
                    "keycode was sent",
                    "UserEntity needs to verify the authentication through the keycode");
    public static final Status INTERNAL_SERVER_ERROR =
            new Status(
                    500,
                    "Internal Server Error",
                    "When an error occurs in the server, eg. could not access database, etc.");
    public static final Status NOT_MODIFIED =
            new Status(304, "Not Modified", "When the data is not changed, etc.");
    private final int code;
    private final String name;
    private final String description;

    public Status(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Status{"
                + "code="
                + code
                + ", name='"
                + name
                + '\''
                + ", description='"
                + description
                + '\''
                + '}';
    }
}
