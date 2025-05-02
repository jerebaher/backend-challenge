package com.directa24.main.challenge.config;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    private final Properties props = new Properties();

    public ApplicationProperties() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load application.properties", e);
        }
    }

    public String getApiUrl() {
        return props.getProperty("api.url");
    }
}
