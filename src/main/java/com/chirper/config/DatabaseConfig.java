package com.chirper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.username}")
    private String dbUsername;

    @Value("${database.password}")
    private String dbPassword;

    @PostConstruct
    public void init() {
        // Set the properties fetched from environment variables
        System.setProperty("spring.datasource.url", System.getenv("DB_URL"));
        System.setProperty("spring.datasource.username", System.getenv("DB_USERNAME"));
        System.setProperty("spring.datasource.password", System.getenv("DB_PASSWORD"));
    }
}

