package com.example.loja;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Dashboard", description = "Dashboard com métricas e indicadores")
public class DashboarController {

    @Operation(summary = "Dashboard", description = "Exibe o dashboard com métricas de vendas, produtos e usuários")
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("title", "Painel Administrativo");
        return "dashboard";
    }
}
