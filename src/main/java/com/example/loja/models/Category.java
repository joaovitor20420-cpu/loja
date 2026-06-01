package com.example.loja.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Categorias de produtos de Streetwear")
public enum Category {
    TSHIRTS("Camisetas", "fas fa-tshirt"),
    HOODIES("Hoodies & Moletons", "fas fa-user-ninja"),
    SNEAKERS("Sneakers", "fas fa-shoe-prints"),
    PANTS("Calças & Cargo", "fas fa-grip-lines"),
    HEADWEAR("Bonés & Toucas", "fas fa-crown"),
    ACCESSORIES("Acessórios", "fas fa-gem"),
    OUTERWEAR("Jaquetas & Corta-vento", "fas fa-wind");

    private final String description;
    private final String icon;

    Category(String description, String icon) {
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
