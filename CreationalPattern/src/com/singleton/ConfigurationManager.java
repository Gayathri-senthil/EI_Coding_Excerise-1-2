package com.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Properties properties;

    private ConfigurationManager() {
        // Load configuration settings from a file or database
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void removeProperty(String key) {
        properties.remove(key);
    }

    public void listProperties() {
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void savePropertiesToFile(String filename) {
        try (FileOutputStream out = new FileOutputStream(filename)) {
            properties.store(out, "Configuration Properties");
            System.out.println("Properties saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPropertiesFromFile(String filename) {
        try (FileInputStream in = new FileInputStream(filename)) {
            properties.load(in);
            System.out.println("Properties loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
