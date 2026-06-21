package com.example.loja.services;
import com.example.loja.models.Order;
import com.example.loja.models.User;
import com.example.loja.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order>findAllOrders(){
        return orderRepository.findAllByOrderByCreatedAtDesc();
    }
    public List<Order> findOrdersByUser(User user) {
        return orderRepository.findByUserOrderByCreatedAtDesc(user);
    }
    public long countOrders(){
        return orderRepository.count();
    }
    
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
