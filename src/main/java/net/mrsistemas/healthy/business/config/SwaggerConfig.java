package net.mrsistemas.healthy.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.mrsistemas.healthy.facade.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Healthy Users Operation API",
                "Api para el control y registro de datos fisicos y personales de los usuarios.",
                "0.0.1",
                "Terms of service",
                new Contact("Max Fredis Tovar Hernández", "www.mrsistemas.net", "maxther911@gmail.com"),
                "License",
                "https://github.com/maxther911/healthyUserService/blob/master/LICENSE",
                Collections.emptyList());
    }
}

