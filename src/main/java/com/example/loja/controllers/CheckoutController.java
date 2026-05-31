package com.example.loja.controllers;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Checkout", description = "Fluxo de finalizaÃ§Ã£o de compra")
public class CheckoutController {
    
    @Operation(summary = "Finalizar compra", description = "Exibe a pÃ¡gina de checkout para finalizaÃ§Ã£o do pedido")
    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("title", "Finalizar Compra");
        return "checkout";
    }
}

