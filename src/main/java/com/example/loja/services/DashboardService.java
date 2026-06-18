package com.example.loja.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;

    public DashboardService(ProductService productService, UserService userService, OrderService orderService) {
        this.productService = productService;
        this.userService = userService;
        this.orderService = orderService;
    }

    public Map<String, Object> getDashboardMetrics() {
        Map<String, Object> metrics = new HashMap<>();


        long totalProducts = productService.countProduct();
        long totalUsers = userService.countUsers();
        long totalOrders = orderService.countOrders();

        java.math.BigDecimal totalRevenue = java.math.BigDecimal.ZERO;
        java.util.List<com.example.loja.models.Order> allOrders = orderService.findAllOrders();
        for (com.example.loja.models.Order o : allOrders) {
            if (o.getTotalAmount() != null && o.getStatus() != com.example.loja.models.Order.OrderStatus.CANCELED) {
                totalRevenue = totalRevenue.add(o.getTotalAmount());
            }
        }
        
        java.util.List<com.example.loja.models.Order> recentOrders = allOrders.stream().limit(5).toList();

        metrics.put("totalProducts", totalProducts);
        metrics.put("totalUsers", totalUsers);
        metrics.put("totalOrders", totalOrders);
        metrics.put("totalRevenue", totalRevenue);
        metrics.put("recentOrders", recentOrders);

        return metrics;
    }
}