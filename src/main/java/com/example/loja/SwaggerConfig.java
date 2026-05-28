package com.example.loja;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração centralizada do Swagger/OpenAPI para documentação da API.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI lojaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Loja E-commerce API")
                        .description("API REST da plataforma de e-commerce. "
                                + "Documentação completa de todos os endpoints disponíveis "
                                + "para gerenciamento de produtos, usuários, pedidos e checkout.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("João Vitor")
                                .email("joaovitor20420@gmail.com")
                                .url("https://github.com/joaovitor20420"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
