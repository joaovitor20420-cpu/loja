package com.example.loja.services;

import com.example.loja.models.Category;
import com.example.loja.models.Product;
import com.example.loja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
                Path uploadPath = Paths.get("C:\\Users\\joaov\\Desktop\\Projetos\\loja\\src\\main\\resources\\uploads");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Files.copy(imageFile.getInputStream(), uploadPath.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING);
                product.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // O ideal aqui seria lancar uma BusinessException customizada
            }
        } else if (product.getId() != null) {
            // Editando sem trocar a imagem: manter a imagem antiga
            Product existing = productRepository.findById(product.getId()).orElse(null);
            if (existing != null) {
                product.setImage(existing.getImage());
            }
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
