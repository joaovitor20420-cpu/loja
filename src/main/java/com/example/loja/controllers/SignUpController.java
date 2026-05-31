package com.example.loja.controllers;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Tag(name = "AutenticaÃ§Ã£o", description = "Endpoints de login e cadastro de usuÃ¡rios")
public class SignUpController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SignUpController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Operation(summary = "PÃ¡gina de cadastro", description = "Exibe o formulÃ¡rio de cadastro de novo usuÃ¡rio")
    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("title", "Cadastro");
        model.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.UserRole.USER);
        user.setStatus(User.UserStatus.ACTIVE);
        userRepository.save(user);

        return "redirect:/signin?success";
    }
}

