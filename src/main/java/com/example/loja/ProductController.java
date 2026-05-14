package com.example.loja;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("title", "Produto");
        model.addAttribute("product", new Product());
        return "product";
    }
    
    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/product";
    } 
    
    @GetMapping("/product/list")
    public String productList(Model model) {
        model.addAttribute("title", "Lista de Produtos");
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Editar Produto");
        model.addAttribute("product", ((Optional<Product>) productRepository.findById(id)).get());
        return "product";
    }

    
}
