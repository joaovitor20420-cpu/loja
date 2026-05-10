package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("title", "Usuários");
        return "users";
    }
}
