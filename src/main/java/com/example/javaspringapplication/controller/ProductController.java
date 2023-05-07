package com.example.javaspringapplication.controller;

import com.example.javaspringapplication.dto.HeartbeatDto;
import com.example.javaspringapplication.dto.ProductTypeReturn;
import com.example.javaspringapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
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
}
