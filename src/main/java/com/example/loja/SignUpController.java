package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    
    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("title", "Cadastro");
        return "sign-up";
    }
}
