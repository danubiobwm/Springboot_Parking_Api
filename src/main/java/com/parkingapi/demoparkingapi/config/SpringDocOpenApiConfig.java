package com.parkingapi.demoparkingapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean(name = "parkingOpenApi")
    public OpenAPI parkingOpenApi() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("security", securityScheme()))
                .info(
                        new Info().title("REST API - Spring boot - Parking API")
                        .description("Parking API reference for management of parking lots")
                        .version("v1.0")
                        .termsOfService("https://swagger.io/terms/")
                        .license(new License().name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
                        .contact(new Contact()
                        .name("J. Danubio de Araujo")
                        .email("danubio.bwm@gmail.com")));
    }
    private SecurityScheme securityScheme() {
        return new SecurityScheme()
                .description("Insira o bearer token valido para autenticar")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("security");
    }
}