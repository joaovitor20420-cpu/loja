package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Usuários", description = "Gestão de usuários da plataforma")
public class UsersController {

    @Operation(summary = "Gestão de usuários", description = "Exibe a página de gerenciamento de usuários")
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("title", "Usuários");
        return "users";
    }
}
