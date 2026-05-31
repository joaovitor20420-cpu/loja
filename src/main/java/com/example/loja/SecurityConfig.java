package com.example.loja;

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

    // AQUI É ONDE A MÁGICA ACONTECE! As regras da alfândega:
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        // Deixamos todo mundo acessar o CSS, imagens, Home e a página de Signin/Signup
                        .requestMatchers("/", "/css/**", "/images/**", "/uploads/**", "/js/**","/signin", "/signup").permitAll()
                        // Qualquer outra página (ex: /admin, /checkout) vai exigir login
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // Dizemos qual é a nossa página de login customizada (aquele seu HTML bonito)
                        .loginPage("/signin")
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        // E também ativamos o Login do Google, usando o seu Consulado!
                        .loginPage("/signin")
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        )
                );

        return http.build();
    }
}