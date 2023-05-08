package com.example.javaspringapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSaveRequest {
    private String name;
    private Integer quantity;
    private Float price;
    private String productTypeId;
}
