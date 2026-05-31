package com.example.loja.controllers;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "UsuÃ¡rios", description = "GestÃ£o de usuÃ¡rios da plataforma")
public class UsersController {

    @Operation(summary = "GestÃ£o de usuÃ¡rios", description = "Exibe a pÃ¡gina de gerenciamento de usuÃ¡rios")
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("title", "UsuÃ¡rios");
        return "users";
    }
}

