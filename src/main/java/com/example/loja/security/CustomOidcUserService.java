package com.example.loja.security;

import com.example.loja.models.User;
import com.example.loja.repositories.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;

    public CustomOidcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        // 1. Deixa o Spring fazer o trabalho sujo de ir no Google buscar os dados
        OidcUser oidcUser = super.loadUser(userRequest);

        // 2. Extraímos o e-mail que veio do Google
        String email = oidcUser.getAttribute("email");
        String name = oidcUser.getAttribute("name");

        // 3. Vamos no nosso banco de dados ver se o usuário já existe
        User usuario = userRepository.findByEmail(email).orElseGet(() -> {
            // Se não existe, a gente cria!
            User novoUser = new User();
            novoUser.setEmail(email);
            novoUser.setFirstName(name != null ? name : "Usuário Google");
            novoUser.setRole(User.UserRole.USER); // Por padrão, é cliente normal
            return userRepository.save(novoUser);
        });

        // Caso o usuário já exista mas ainda não seja ADMIN e o e-mail for o seu
        if ("joaovitor20420@gmail.com".equals(email) && usuario.getRole() != User.UserRole.ADMIN) {
            usuario.setRole(User.UserRole.ADMIN);
            usuario = userRepository.save(usuario);
        }

        // 4. Monta nosso Crachá Unificado que agora suporta OIDC
        CustomUserDetails customUserDetails = new CustomUserDetails(usuario);
        customUserDetails.setAttributes(oidcUser.getAttributes());
        customUserDetails.setIdToken(oidcUser.getIdToken());
        customUserDetails.setUserInfo(oidcUser.getUserInfo());

        return customUserDetails;
    }
}
