package com.application.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Example bean: welcome message
    @Bean
    public String welcomeMessage() {
        return "Welcome to the Backend!";
    }
}
