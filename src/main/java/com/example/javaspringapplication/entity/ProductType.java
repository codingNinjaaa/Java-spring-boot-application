package com.example.javaspringapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Table(name = "product_type")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {
    @Id
    @Column(name="Product_type_id")
    private String productTypeId;

    @Column(name="Product_type_description")
    private byte[] productTypeDescription;
}
