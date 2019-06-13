package com.jsv.rest.util;

public class Constants {
    /**
     * Property file values.
     */
    public enum ConfigProperties {
        HOST_URL("host.url");

        private String value;

        ConfigProperties(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
