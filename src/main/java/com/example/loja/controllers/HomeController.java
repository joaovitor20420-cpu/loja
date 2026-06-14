package com.example.loja.controllers;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import com.example.loja.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Home", description = "PÃ¡gina inicial da loja virtual (vitrine pÃºblica)")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Pagina inicial", description = "Exibe o catalogo publico de produtos com filtro opcional por categoria")
    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "ALL") String category,
                        Model model) {
        model.addAttribute("title", "Sua Loja Online Completa");
        model.addAttribute("categories", Category.values());
        model.addAttribute("selectedCategory", category != null ? category : "ALL");
        if(category.equals("ALL")){
            model.addAttribute("products", productService.getAllProducts());
        } else {
            Category cat = Category.valueOf(category);
            model.addAttribute("products", productService.getProductsByCategory(cat));
        }

        

        return "index";
    }

}

