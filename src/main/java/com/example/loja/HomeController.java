package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Sua Loja Online Completa");

        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("categories", Category.values());

        return "index";
    }

}
