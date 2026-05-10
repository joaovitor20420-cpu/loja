package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduvtController {
    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("title", "Produto");
        return "product";
    }
}
