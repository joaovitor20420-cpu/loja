package com.example.loja.security;
import com.example.loja.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class CustomUserDetails implements UserDetails, OAuth2User, OidcUser {
    private final User user;
    private Map<String, Object> attributes;
    private OidcIdToken idToken;
    private OidcUserInfo userInfo;
    public CustomUserDetails(User user) {
        this.user = user;
    }
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    public void setIdToken(OidcIdToken idToken) {
        this.idToken = idToken;
    }
    public void setUserInfo(OidcUserInfo userInfo) {
        this.userInfo = userInfo;
    }
    @Override
    public Map<String, Object> getClaims() {
        return attributes;
    }
    @Override
    public OidcUserInfo getUserInfo() {
        return userInfo;
    }
    @Override
    public OidcIdToken getIdToken() {
        return idToken;
    }
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    @Override
    public String getName() {
        return user.getEmail();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = (user.getRole() != null) ? user.getRole().name() : "USER";
        return List.of(new SimpleGrantedAuthority("ROLE_" + roleName));
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
