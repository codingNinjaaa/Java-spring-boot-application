package com.example.javaspringapplication.service;

import com.example.javaspringapplication.dto.ProductType;
import com.example.javaspringapplication.dto.ProductTypeReturn;
import com.example.javaspringapplication.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

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
}
