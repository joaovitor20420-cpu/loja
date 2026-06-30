package com.example.loja.controllers;
import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Controller
@Tag(name = "Admin", description = "Ãrea administrativa da plataforma")
public class AdmimController {
    @Operation(summary = "Painel administrativo", description = "Exibe a pÃ¡gina principal da Ã¡rea administrativa")
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("title", "Area Administrativa");
        return "admin";
    }
}
