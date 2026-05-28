package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Autenticação", description = "Endpoints de login e cadastro de usuários")
public class SignInController {

    @Operation(summary = "Página de login", description = "Exibe o formulário de login do usuário")
    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("title", "Login");
        return "signin";
    }
}
