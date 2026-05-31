package com.example.loja.config;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, CustomOAuth2UserService customOAuth2UserService) {
        this.customUserDetailsService = customUserDetailsService;
        this.customOAuth2UserService = customOAuth2UserService;
    }

    // O Spring exige que a gente ensine ele a criptografar senhas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AQUI Ã‰ ONDE A MÃGICA ACONTECE! As regras da alfÃ¢ndega:
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        // Deixamos todo mundo acessar o CSS, imagens, Home e a pÃ¡gina de Signin/Signup
                        .requestMatchers("/", "/css/**", "/images/**", "/uploads/**", "/js/**","/signin", "/signup").permitAll()
                        // Qualquer outra pÃ¡gina (ex: /admin, /checkout) vai exigir login
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // Dizemos qual Ã© a nossa pÃ¡gina de login customizada (aquele seu HTML bonito)
                        .loginPage("/signin")
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        // E tambÃ©m ativamos o Login do Google, usando o seu Consulado!
                        .loginPage("/signin")
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        )
                );

        return http.build();
    }
}
