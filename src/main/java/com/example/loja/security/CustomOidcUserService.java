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
        OidcUser oidcUser = super.loadUser(userRequest);
        String email = oidcUser.getAttribute("email");
        String name = oidcUser.getAttribute("name");
        User usuario = userRepository.findByEmail(email).orElseGet(() -> {
            User novoUser = new User();
            novoUser.setEmail(email);
            novoUser.setFirstName(name != null ? name : "Usuário Google");
            novoUser.setRole(User.UserRole.USER); 
            return userRepository.save(novoUser);
        });
        if ("joaovitor20420@gmail.com".equals(email) && usuario.getRole() != User.UserRole.ADMIN) {
            usuario.setRole(User.UserRole.ADMIN);
            usuario = userRepository.save(usuario);
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(usuario);
        customUserDetails.setAttributes(oidcUser.getAttributes());
        customUserDetails.setIdToken(oidcUser.getIdToken());
        customUserDetails.setUserInfo(oidcUser.getUserInfo());
        return customUserDetails;
    }
}
