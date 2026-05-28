package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Admin", description = "Área administrativa da plataforma")
public class AdmimController {
    
    @Operation(summary = "Painel administrativo", description = "Exibe a página principal da área administrativa")
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("title", "Área Administrativa");
        return "admin";
    }
}   
