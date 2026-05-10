package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("title", "Pedidos");
        return "orders";
    }
}
