package com.example.loja.services;

import com.example.loja.models.CartItem;
import com.example.loja.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class CartService {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        Optional<CartItem> existingItem = items.stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            items.add(new CartItem(product, quantity, product.getPrice() * quantity));
        }
    }

    public void removeItem(Long productId) {
        items.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }
    
    public int getTotalItems() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }
}
