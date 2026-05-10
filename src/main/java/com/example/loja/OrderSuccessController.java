package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderSuccessController {
    
    @GetMapping("/order-success")
    public String orderSuccess(Model model) {
        model.addAttribute("title", "Pedido Realizado");
        return "order-success";
    }
}
