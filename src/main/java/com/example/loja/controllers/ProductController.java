package com.example.loja.controllers;

import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de produtos (CRUD)")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Operation(summary = "Listar produtos", description = "Exibe a pÃ¡gina de gerenciamento de produtos com filtro opcional por categoria")
    @GetMapping("/product")
    public String product(@RequestParam(required = false, defaultValue = "ALL") String category,
            Model model) {
        model.addAttribute("categories", Category.values());
        model.addAttribute("product", new Product());
        model.addAttribute("selectedCategory", category != null && !category.isEmpty() ? category : "ALL");
        if ("ALL".equals(category)) {
            model.addAttribute("products", productRepository.findAll());
        } else {
            Category cat = Category.valueOf(category);
            model.addAttribute("products", productRepository.findByCategory(cat));
        }

        return "product";
    }

    @Operation(summary = "Salvar produto", description = "Cria ou atualiza um produto, incluindo upload opcional de imagem")
    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
                Path uploadPath = Paths.get("uploads");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Files.copy(imageFile.getInputStream(), uploadPath.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING);
                product.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (product.getId() != null) {
            // Editando sem trocar a imagem: manter a imagem antiga
            Product existing = productRepository.findById(product.getId()).orElse(null);
            if (existing != null) {
                product.setImage(existing.getImage());
            }
        }

        productRepository.save(product);
        return "redirect:/product";
    }

    @Operation(summary = "Listar todos os produtos", description = "Exibe a lista completa de produtos cadastrados")
    @GetMapping("/product/list")
    public String productList(Model model) {
        model.addAttribute("title", "Lista de Produtos");
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @Operation(summary = "Editar produto", description = "Carrega os dados de um produto especÃ­fico para ediÃ§Ã£o")
    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Editar Produto");
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("categories", Category.values());
        model.addAttribute("product", ((Optional<Product>) productRepository.findById(id)).get());
        return "product";
    }

    @Operation(summary = "Excluir produto", description = "Remove um produto pelo seu ID")
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/product";
    }

}

