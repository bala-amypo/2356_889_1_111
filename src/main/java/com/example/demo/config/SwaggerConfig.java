package com.example.demo.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9353.pro604cr.amypo.ai/")
                ));
         public void api() {
        }
    }
}