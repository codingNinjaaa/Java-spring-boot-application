package com.example.javaspringapplication.repository;

import com.example.javaspringapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
