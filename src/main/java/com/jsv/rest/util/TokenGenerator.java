package com.jsv.rest.util;

import java.security.SecureRandom;

public class TokenGenerator {

    protected static SecureRandom random = new SecureRandom();

    /**
     * Generate base 16 string.
     * @return base 16 string.
     */
    public synchronized String generateToken() {
        long longToken = Math.abs( random.nextLong() );
        String random = Long.toString( longToken, 16 );
        return random;
    }
}
