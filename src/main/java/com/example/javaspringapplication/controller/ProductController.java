package com.example.javaspringapplication.controller;

import com.example.javaspringapplication.dto.*;
import com.example.javaspringapplication.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@Slf4j
public class ProductController {

    @Value("${application.name}")
    private String applicationName;

    @Autowired
    private ProductService productService;

    @GetMapping("/heartbeat")
    public ResponseEntity heartbeat(){
        ResponseEntity<HeartbeatDto> result = new ResponseEntity<>(new HeartbeatDto(applicationName, "Hooray application is working", String.valueOf(Instant.now())), HttpStatusCode.valueOf(200));
        return result;
    }

    @GetMapping("/productType/{productTypeId}")
    public ResponseEntity getProductType(@PathVariable String productTypeId){
        return new ResponseEntity<ProductTypeReturn>(productService.getProductType(productTypeId), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/product/")
    public ResponseEntity getProduct(@RequestParam("productId") String productId){
        ProductReturn productReturn = productService.getProductById(productId);
        if(productReturn == null)
            return new ResponseEntity("No data found", HttpStatusCode.valueOf(204));
        else
            return new ResponseEntity(productReturn, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/product")
    public ResponseEntity saveProduct(@RequestBody ProductSaveRequest request){
        productService.saveProduct(request);
        return new ResponseEntity(HttpStatusCode.valueOf(201));
    }

    @PostMapping("/product-type")
    public ResponseEntity saveProductType(@RequestBody ProductTypeSaveRequest request){
        productService.saveProductType(request);
        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }

    @PostMapping("/product-name")
    public ResponseEntity findProductByName(@RequestBody ProductByNameRequest request){
        return new ResponseEntity(productService.findProductByName(request), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/product/{minPrice}/{maxPrice}")
    public ResponseEntity findProductByPrice(@PathVariable float minPrice, @PathVariable float maxPrice){
        return new ResponseEntity(productService.findProductByPrice(minPrice, maxPrice), HttpStatusCode.valueOf(200));
    }
}
