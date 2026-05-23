package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "ALL") String category,
                        Model model) {
        model.addAttribute("title", "Sua Loja Online Completa");
        model.addAttribute("categories", Category.values());
        model.addAttribute("selectedCategory", category != null ? category : "ALL");
        if(category.equals("ALL")){
            model.addAttribute("products", productRepository.findAll());
        } else {
            Category cat = Category.valueOf(category);
            model.addAttribute("products",productRepository.findByCategory(cat));
        }

        

        return "index";
    }

}
