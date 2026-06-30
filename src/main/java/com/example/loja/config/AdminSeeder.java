package com.example.loja.config;
import com.example.loja.models.User;
import com.example.loja.repositories.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public class AdminSeeder {
    private final UserRepository userRepository;
    private static final String DONO_DA_LOJA_EMAIL = "joaovitor20420@gmail.com";
    public AdminSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void garantirAcessoDoDono() {
        Optional<User> donoDaLoja = userRepository.findByEmail(DONO_DA_LOJA_EMAIL);
        if (donoDaLoja.isPresent()) {
            User user = donoDaLoja.get();
            if (user.getRole() != User.UserRole.ADMIN) {
                user.setRole(User.UserRole.ADMIN);
                userRepository.save(user);
                System.out.println("✅ CHAVE MESTRA ATIVADA: O usuário " + DONO_DA_LOJA_EMAIL + " foi promovido a ADMIN!");
            }
        } else {
            System.out.println("⚠️ AVISO: O dono da loja (" + DONO_DA_LOJA_EMAIL + ") ainda não se cadastrou. Cadastre-se ou faça login com o Google para receber o crachá de ADMIN.");
        }
    }
}
