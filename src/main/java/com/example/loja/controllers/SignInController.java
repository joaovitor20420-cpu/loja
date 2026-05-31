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
@Tag(name = "AutenticaÃ§Ã£o", description = "Endpoints de login e cadastro de usuÃ¡rios")
public class SignInController {

    @Operation(summary = "PÃ¡gina de login", description = "Exibe o formulÃ¡rio de login do usuÃ¡rio")
    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("title", "Login");
        return "signin";
    }
}

