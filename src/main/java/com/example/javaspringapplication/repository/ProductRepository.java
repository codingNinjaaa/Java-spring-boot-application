package com.example.javaspringapplication.repository;

import com.example.javaspringapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByName(String name);

    @Query(value = "SELECT * FROM product as p WHERE p.Price>?1 AND p.PRICE<?2", nativeQuery = true)
    List<Product> findProductsByPrice(float minPrice, float maxPrice);
}
