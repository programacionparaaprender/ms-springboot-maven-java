package com.program.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class AppConfig {

    @Bean
    public WebFluxConfigurer corsConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Permitir tanto /graphql/** como /graphiql/**
                registry.addMapping("/graphql/**")
                        .allowedOrigins("http://localhost:8762")
                        .allowedMethods("*");

                registry.addMapping("/graphiql/**")
                        .allowedOrigins("http://localhost:8762")
                        .allowedMethods("*");
            }
        };
    }
}
