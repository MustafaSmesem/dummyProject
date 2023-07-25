package com.joumer.dummyproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Mobileaction dummy app", version = "1.0.2"),
        servers = {
                @Server(url = "https://gateway.mobileaction.co", description = "prod gateway"),
                @Server(url = "https://gateway-testing.mobileaction.co", description = "dev gateway")
        },
        tags = {
                @Tag(name = "User endpoint", description = "to control users entity")
        }
)
@SecurityScheme(
        name = "Jwt bearer",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "Bearer token for authorization."
)
public class DummyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyProjectApplication.class, args);
    }

}
