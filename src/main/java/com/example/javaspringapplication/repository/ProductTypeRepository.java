package com.example.javaspringapplication.repository;

import com.example.javaspringapplication.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
}
