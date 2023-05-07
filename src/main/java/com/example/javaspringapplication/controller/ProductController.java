package com.example.javaspringapplication.controller;

import com.example.javaspringapplication.dto.HeartbeatDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class ProductController {

    @Value("${application.name}")
    private String applicationName;

    @GetMapping("/heartbeat")
    public ResponseEntity heartbeat(){
        ResponseEntity<HeartbeatDto> result = new ResponseEntity<>(new HeartbeatDto(applicationName, "Hooray application is working", String.valueOf(Instant.now())), HttpStatusCode.valueOf(200));
        return result;
    }
}
