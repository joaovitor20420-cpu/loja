package com.example.loja;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Categorias de produtos disponíveis na loja")
public enum Category {
    CLOTHING("Roupas", "fa fa-tshirt"),
    FOOTWEAR("Calçados", "fa fa-shoe-prints"),
    ACCESSORIES("Acessórios", "fa fa-gem"),
    ELECTRONICS("Eletrônicos", "fa fa-laptop"),
    HOME_DECOR("Casa e Decoração", "fa fa-home"),
    BEAUTY_HEALTH("Beleza e Saúde", "fa fa-heart"),
    SPORTS_LEISURE("Esportes e Lazer", "fa fa-football-ball"),
    BOOKS_MUSIC_MOVIES("Livros, Músicas e Filmes", "fa fa-book"),
    FOOD("Alimentos", "fa fa-utensils"),
    OTHERS("Outros", "fa fa-th");

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
