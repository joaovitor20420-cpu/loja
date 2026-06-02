package com.example.loja.security;

import com.example.loja.models.User;
import com.example.loja.repositories.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 1. Recebe o usuário validado do Google
        OAuth2User googleUser = super.loadUser(userRequest);
        String email = googleUser.getAttribute("email");
        String name = googleUser.getAttribute("name");
        
        // 2. Busca ou Cria o usuário no banco
        User usuario = userRepository.findByEmail(email).orElseGet(() -> {
            User novoUsuario = new User();
            novoUsuario.setEmail(email);
            novoUsuario.setFirstName(name);
            
            // Promoção Imediata na criação
            if ("joaovitor20420@gmail.com".equals(email)) {
                novoUsuario.setRole(User.UserRole.ADMIN);
            } else {
                novoUsuario.setRole(User.UserRole.USER);
            }
            
            novoUsuario.setStatus(User.UserStatus.ACTIVE);
            novoUsuario.setPassword("LOGIN_GOOGLE");
            return userRepository.save(novoUsuario);
        });

        // Caso o usuário já exista mas ainda não seja ADMIN
        if ("joaovitor20420@gmail.com".equals(email) && usuario.getRole() != User.UserRole.ADMIN) {
            usuario.setRole(User.UserRole.ADMIN);
            userRepository.save(usuario);
        }

        // 3. Monta nosso Crachá Unificado (Spring Security Normal + Google)
        CustomUserDetails customUserDetails = new CustomUserDetails(usuario);
        customUserDetails.setAttributes(googleUser.getAttributes());
        
        return customUserDetails;
    }
}
