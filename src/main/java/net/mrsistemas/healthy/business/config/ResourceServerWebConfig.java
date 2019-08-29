package net.mrsistemas.healthy.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"net.mrsistemas.healthy.facade.controllers"})
public class ResourceServerWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // Make Swagger meta-data available via <baseURL>/v2/api-docs/
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // Make Swagger UI available via <baseURL>/swagger-ui.html
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
    }

}
