package com.example.loja.security;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import org.springframework.beans.factory.annotation.Autowired;
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
        // 1. Manda o Spring fazer o trabalho sujo de converter o JSON do Google num Objeto Java
        OAuth2User googleUser = super.loadUser(userRequest);
        String email = googleUser.getAttribute("email");
        String name = googleUser.getAttribute("name");
        if (userRepository.findByEmail(email).isEmpty()){
            User novoUsuario = new User();
            novoUsuario.setEmail(email);
            novoUsuario.setFirstName(name);
            novoUsuario.setRole(User.UserRole.USER);
            novoUsuario.setStatus(User.UserStatus.ACTIVE);
            novoUsuario.setPassword("LOGIN_GOOGLE");
            userRepository.save(novoUsuario);
        }
        return googleUser;
    }
}
