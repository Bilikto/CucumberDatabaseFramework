package com.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReaderUtils {

    private static Properties property;
    private static String configFilePath = "/src/test/resources/config/config.properties";


    public static void initConfig() {
        property = new Properties();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir") + configFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }

}
