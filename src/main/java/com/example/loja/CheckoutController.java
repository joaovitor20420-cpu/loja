package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Checkout", description = "Fluxo de finalização de compra")
public class CheckoutController {
    
    @Operation(summary = "Finalizar compra", description = "Exibe a página de checkout para finalização do pedido")
    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("title", "Finalizar Compra");
        return "checkout";
    }
}
