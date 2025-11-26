package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI  api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mi API con Swagger")
                        .version("1.0")
                        .description("Documentación generada automáticamente con Springdoc OpenAPI"));
    }
}



