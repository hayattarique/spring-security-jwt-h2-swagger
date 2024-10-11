package org.restapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info = @Info(
        title = "Product API",
        version = "1.0",
        description = "This is a Product API to demonstrate OpenAPI documentation",
        contact = @Contact(
                name = "Hayat",
                email = "hayattarique3@gmail.com"
        )
),
        servers = @Server(
                url = "http://localhost:8082",
                description = "Local server"
        )
)
public class SwaggerConfig {
    @Bean
    GroupedOpenApi openApi() {
        return GroupedOpenApi.builder().group("Product").
                pathsToMatch("/product/*").packagesToScan("org.restapi.controller").build();
    }
}
