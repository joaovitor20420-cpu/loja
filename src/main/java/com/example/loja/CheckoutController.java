package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    
    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("title", "Finalizar Compra");
        return "checkout";
    }
}
