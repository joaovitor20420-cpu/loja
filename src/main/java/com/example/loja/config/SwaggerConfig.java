package com.example.loja.config;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConfiguraÃ§Ã£o centralizada do Swagger/OpenAPI para documentaÃ§Ã£o da API.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI lojaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Loja E-commerce API")
                        .description("API REST da plataforma de e-commerce. "
                                + "DocumentaÃ§Ã£o completa de todos os endpoints disponÃ­veis "
                                + "para gerenciamento de produtos, usuÃ¡rios, pedidos e checkout.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("JoÃ£o Vitor")
                                .email("joaovitor20420@gmail.com")
                                .url("https://github.com/joaovitor20420"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}

