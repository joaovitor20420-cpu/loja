package com.example.loja.controllers;

import com.example.loja.models.CartItem;
import com.example.loja.models.Order;
import com.example.loja.models.OrderItem;
import com.example.loja.models.Product;
import com.example.loja.models.User;
import com.example.loja.services.CartService;
import com.example.loja.services.OrderService;
import com.example.loja.services.ProductService;
import com.example.loja.services.StripeService;
import com.example.loja.services.UserService;
import com.example.loja.security.CustomUserDetails;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Tag(name = "Checkout", description = "Fluxo de finalização de compra")
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private StripeService stripeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    
    private final String stripePublicKey = "pk_test_51TkpXA4nVzFhQkuGq6pg4yJgkbxzFux3WqoZLkNsv6ZLIz6NRaOJkBYfvWHHVsiuEmJ9Q8v515Mv4SqzBMWVzDjJ00sAuCKEIK";

    @Operation(summary = "Finalizar compra", description = "Exibe a página de checkout gerando a intenção de pagamento no Stripe")
    @GetMapping("/checkout")
    public String checkout(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (cartService.getItems().isEmpty()) {
            return "redirect:/";
        }

        try {
            // Stripe espera o valor em centavos (ex: R$ 50,00 = 5000 centavos)
            long amountInCents = (long) (cartService.getTotalAmount() * 100);
            PaymentIntent paymentIntent = stripeService.createPaymentIntent(amountInCents, "brl");
            
            // Enviamos o client_secret (segredo do pagamento) para o HTML renderizar o form do cartão
            model.addAttribute("clientSecret", paymentIntent.getClientSecret());
            model.addAttribute("stripePublicKey", stripePublicKey);
            
            model.addAttribute("cartItems", cartService.getItems());
            model.addAttribute("cartTotalAmount", cartService.getTotalAmount());
            model.addAttribute("title", "Finalizar Compra");

            return "checkout";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao conectar com Stripe: " + e.getMessage());
            return "redirect:/";
        }
    }

    @Operation(summary = "Processar Pagamento", description = "Rota chamada após o cartão ser aprovado pelo Stripe")
    @PostMapping("/checkout/process")
    public String processPaymentSuccess(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (cartService.getItems().isEmpty() || userDetails == null) {
            return "redirect:/";
        }

        // Gera o pedido oficial no banco de dados!
        Order order = new Order();
        // Busca o usuário completo pelo e-mail
        User user = userService.findByEmail(userDetails.getUsername()).orElse(null);
        if (user == null) {
            return "redirect:/";
        }
        order.setUser(user);
        order.setTotalAmount(BigDecimal.valueOf(cartService.getTotalAmount()));
        order.setStatus(Order.OrderStatus.PAID);
        
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem item : cartService.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPriceAtPurchase(BigDecimal.valueOf(item.getProduct().getPrice()));
            orderItems.add(orderItem);

            // Reduz estoque automaticamente
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
            productService.saveProduct(product, null);
        }
        order.setItems(orderItems);

        orderService.saveOrder(order);
        
        // Esvazia a sacola após a compra concluída
        cartService.clearCart();

        return "redirect:/order-success";
    }

}
