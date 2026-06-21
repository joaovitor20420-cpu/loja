package com.example.loja.models;

public class CartItem {
    private Product product;
    private int quantity;
    private double subtotal;

    public CartItem() {
    }

    public CartItem(Product product, int quantity, double subtotal) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = this.product.getPrice() * this.quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
