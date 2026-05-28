package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Checkout", description = "Fluxo de finalização de compra")
public class OrderSuccessController {
    
    @Operation(summary = "Pedido confirmado", description = "Exibe a página de confirmação após a realização do pedido")
    @GetMapping("/order-success")
    public String orderSuccess(Model model) {
        model.addAttribute("title", "Pedido Realizado");
        return "order-success";
    }
}
