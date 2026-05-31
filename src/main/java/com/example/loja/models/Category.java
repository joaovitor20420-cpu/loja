package com.example.loja.models;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Categorias de produtos disponÃ­veis na loja")
public enum Category {
    CLOTHING("Roupas", "fa fa-tshirt"),
    FOOTWEAR("CalÃ§ados", "fa fa-shoe-prints"),
    ACCESSORIES("AcessÃ³rios", "fa fa-gem"),
    ELECTRONICS("EletrÃ´nicos", "fa fa-laptop"),
    HOME_DECOR("Casa e DecoraÃ§Ã£o", "fa fa-home"),
    BEAUTY_HEALTH("Beleza e SaÃºde", "fa fa-heart"),
    SPORTS_LEISURE("Esportes e Lazer", "fa fa-football-ball"),
    BOOKS_MUSIC_MOVIES("Livros, MÃºsicas e Filmes", "fa fa-book"),
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

