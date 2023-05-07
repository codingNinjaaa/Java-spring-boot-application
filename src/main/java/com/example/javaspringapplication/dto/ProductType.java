package com.example.javaspringapplication.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "product_type")
@Entity
public class ProductType {
    @Id
    @Column(name="Product_type_id")
    private String productTypeId;

    @Column(name="Product_type_description")
    private byte[] productTypeDescription;
}
