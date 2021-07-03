package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> getHealthStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}