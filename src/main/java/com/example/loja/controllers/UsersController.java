package com.example.loja.controllers;

import com.example.loja.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Usuários", description = "Gestão de usuários da plataforma")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Gestão de usuários", description = "Exibe a página de gerenciamento de usuários")
    @GetMapping("/admin/users")
    public String users(Model model) {
        model.addAttribute("title", "Clientele - Admin");
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }
}
