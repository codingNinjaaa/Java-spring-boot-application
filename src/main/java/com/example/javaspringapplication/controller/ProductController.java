package com.example.javaspringapplication.controller;

import com.example.javaspringapplication.dto.HeartbeatDto;
import com.example.javaspringapplication.dto.ProductReturn;
import com.example.javaspringapplication.dto.ProductSaveRequest;
import com.example.javaspringapplication.dto.ProductTypeReturn;
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
}
