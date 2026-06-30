package com.example.loja.controllers;
import com.example.loja.services.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
@Controller
@Tag(name = "Dashboard", description = "Dashboard com métricas e indicadores")
public class DashboardController {
    private final DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
    @Operation(summary = "Dashboard", description = "Exibe o dashboard com métricas de vendas, produtos e usuários")
    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        Map<String, Object> metrics = dashboardService.getDashboardMetrics();
        model.addAttribute("title", "Painel Administrativo");
        model.addAttribute("totalProducts", metrics.get("totalProducts"));
        model.addAttribute("totalUsers", metrics.get("totalUsers"));
        model.addAttribute("totalOrders", metrics.get("totalOrders"));
        model.addAttribute("totalRevenue", metrics.get("totalRevenue"));
        model.addAttribute("recentOrders", metrics.get("recentOrders"));
        return "dashboard";
    }
}