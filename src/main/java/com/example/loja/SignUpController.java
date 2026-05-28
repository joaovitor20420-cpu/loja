package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Autenticação", description = "Endpoints de login e cadastro de usuários")
public class SignUpController {
    
    @Operation(summary = "Página de cadastro", description = "Exibe o formulário de cadastro de novo usuário")
    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("title", "Cadastro");
        return "signup";
    }
}
