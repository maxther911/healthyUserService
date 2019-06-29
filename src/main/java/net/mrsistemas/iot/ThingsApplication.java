package net.mrsistemas.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"net.mrsistemas.iot"})
public class ThingsApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ThingsApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(">=== Inside Cors Orgin Mapping addCorsMappings ===>");
        registry.addMapping("/users/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(10000);
        registry.addMapping("/devices/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(10000);
    }

}

