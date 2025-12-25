package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    /**
     * REQUIRED by testcase:
     * DemoMassiveTestNGTests.t115_config_swaggerOpenApiBean()
     */
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hostel Roommate Compatibility Matcher API")
                        .version("1.0.0")
                        .description("API documentation for Hostel Roommate Compatibility Matcher"))
                .servers(List.of(
                        new Server().url("https://9353.pro604cr.amypo.ai/")
                ));
    }
}
