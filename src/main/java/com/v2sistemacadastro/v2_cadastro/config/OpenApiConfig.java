package com.v2sistemacadastro.v2_cadastro.config;

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
                        .title("API de Cadastro de Usuários")
                        .version("v1")
                        .description("Sistema de gerenciamento de usuários desenvolvido com Spring Boot e Java 21"));
    }
}