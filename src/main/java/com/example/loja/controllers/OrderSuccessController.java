package com.example.loja.controllers;
import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.GetMapping;import io.swagger.v3.oas.annotations.Operation;import io.swagger.v3.oas.annotations.tags.Tag;@Controller@Tag(name = "Checkout", description = "Fluxo de finalizaÃ§Ã£o de compra")public class OrderSuccessController {    @Operation(summary = "Pedido confirmado", description = "Exibe a pÃ¡gina de confirmaÃ§Ã£o apÃ³s a realizaÃ§Ã£o do pedido")    @GetMapping("/order-success")    public String orderSuccess(Model model) {        model.addAttribute("title", "Pedido Realizado");        return "order-success";    }}