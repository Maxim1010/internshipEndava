package org.github.java8.examples.optionals;

import java.util.Properties;

public class PropertiesReader {

    public static Properties buildMockProperties() {
        Properties props = new Properties();
        props.setProperty("readTimeout", "5");
        props.setProperty("writeTimeout", "-1");
        return props;
    }


}
