package com.jsv.rest.util;

import java.security.SecureRandom;

public class TokenGenerator {

    private static SecureRandom random = new SecureRandom();

    /**
     * Generate base 16 string.
     * @return base 16 string.
     */
    public static synchronized String generateToken() {
        long longToken = Math.abs( random.nextLong() );
        return Long.toString( longToken, 16 );
    }
}
