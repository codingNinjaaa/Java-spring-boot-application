package com.example.javaspringapplication.service;

import com.example.javaspringapplication.dto.*;
import com.example.javaspringapplication.entity.Product;
import com.example.javaspringapplication.entity.ProductType;
import com.example.javaspringapplication.exception.BadRequestException;
import com.example.javaspringapplication.repository.ProductRepository;
import com.example.javaspringapplication.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductRepository productRepository;

    public ProductTypeReturn getProductType(String productTypeId){
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(productTypeId);
        if(productTypeOptional.isPresent()){
            ProductTypeReturn returnObject = new ProductTypeReturn();
            returnObject.setProductTypeId(productTypeOptional.get().getProductTypeId());
            returnObject.setProductTypeDescription(new String(productTypeOptional.get().getProductTypeDescription(), StandardCharsets.UTF_8));
            return returnObject;
        }else{
            return null;
        }
    }

    public ProductReturn getProductById(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return new ProductReturn(product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getProductType());
        }
        return null;
    }

    public void saveProduct(ProductSaveRequest request) throws BadRequestException {
        if(request.getName() == null || request.getName().length()==0)
            throw new BadRequestException("Product Name not present");
        Product product = new Product(String.valueOf(UUID.randomUUID()), request.getName(), request.getQuantity(), request.getPrice(), request.getProductTypeId());
        productRepository.save(product);
    }

    public void saveProductType(ProductTypeSaveRequest request) {
        ProductType productType = new ProductType(String.valueOf(UUID.randomUUID()), request.getProductTypeDescription().getBytes(StandardCharsets.UTF_8));
        productTypeRepository.save(productType);
    }


    public List<Product> findProductByName(ProductByNameRequest request) {
        return productRepository.findByName(request.getName());
    }

    public List<Product> findProductByPrice(float minPrice, float maxPrice) {
        return productRepository.findProductsByPrice(minPrice, maxPrice);
    }
}
