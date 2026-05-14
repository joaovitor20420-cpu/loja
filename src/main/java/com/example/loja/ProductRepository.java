package com.example.loja;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByname(String name);
    Product findByPrice(double price);
    Product findByDescription(String description);
    Product findByImage(String image);
    Product findByCategory(String category);
    Product findByBrand(String brand);
    Product findByStatus(String status);
    Product findByStock(int stock);
    
    @Override
    @NonNull
    Product save(@NonNull Product product);

    @Override
    @NonNull
    List<Product> findAll();

    @Override
    @NonNull
    Optional<Product> findById(Long id);

    @Override
    void deleteById(Long id);
}