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
@Tag(name = "Pedidos", description = "Gestão de pedidos da loja")
public class OrdersController {

    @Operation(summary = "Gestão de pedidos", description = "Exibe a página de gerenciamento de pedidos")
    @GetMapping("/admin/orders")
    public String orders(Model model) {
        model.addAttribute("title", "Pedidos");
        return "orders";
    }
}
