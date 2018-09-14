package org.github.java8.examples.optionals;

import java.util.Optional;
import java.util.Properties;

public class ApplicationConfiguration {
    public static final String WRITE_TIMEOUT = "writeTimeout";
    public static final String READ_TIMEOUT = "readTimeout";
    public static final int VALUE_DEFAULT_READ_TIMEOUT = 5;
    public static final int VALUE_DEFAULT_WRITE_TIMEOUT = 5;
    private Properties properties;

    ApplicationConfiguration(Properties properties) {
        this.properties = properties;
    }

    private int readPropertyOldWay(String field, int defaultValue) {
        String s = this.properties.getProperty(field);
        if(s != null) {
            try {
                int value = Integer.parseInt(s);
                if(value > 0) {
                    return value;
                }
            } catch (NumberFormatException nfe) {/**/}
        }
        return defaultValue;
    }

    public int readDuration(String field, int defaultValue) {
        return Optional.ofNullable(properties.getProperty(field))
                .flatMap(OptionalUtil::parseString)
                .filter(i -> i > 0)
                .orElse(defaultValue);
    }

    public int gerReadTimeOut() {
        return readPropertyOldWay(READ_TIMEOUT, VALUE_DEFAULT_READ_TIMEOUT);
    }

    public int getWriteTimeout() {
        return readPropertyOldWay(WRITE_TIMEOUT, VALUE_DEFAULT_WRITE_TIMEOUT);
    }
}
