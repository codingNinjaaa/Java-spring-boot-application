package com.example.javaspringapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Product_type")
    private String productType;
}
