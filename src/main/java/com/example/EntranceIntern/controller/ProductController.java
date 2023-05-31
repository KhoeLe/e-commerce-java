package com.example.EntranceIntern.controller;

import java.util.List;

import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EntranceIntern.model.Product;
import com.example.EntranceIntern.services.ProductServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    

    @Autowired ProductServices productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product product){
        return productService.create(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return productService.findAll();
    }
}
