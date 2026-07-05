package com.zulim_antonio.abysalto_test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("solution-antonio_zulim")
                .version("0.1")
                .description("REST API for retrieving and filtering products, backed by dummyjson.com"));
    }
}
