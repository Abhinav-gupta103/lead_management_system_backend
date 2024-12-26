package com.lead_management_system.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all routes starting with /api/*
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // React app URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // HTTP methods allowed
                .allowedHeaders("*") // Allow any headers
                .allowCredentials(true); // Allow credentials (cookies or Authorization header)
    }
}
