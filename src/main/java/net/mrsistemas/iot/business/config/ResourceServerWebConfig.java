package net.mrsistemas.iot.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"net.mrsistemas.iot.facade.controllers"})
public class ResourceServerWebConfig implements WebMvcConfigurer {}
