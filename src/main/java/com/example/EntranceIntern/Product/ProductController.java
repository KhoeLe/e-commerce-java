package com.example.EntranceIntern.Product;

import java.util.List;

import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/v1/products")
public class ProductController {
    

    @Autowired ProductServices productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product product){
       try {
        return productService.create(product);
       } catch (Exception e) {
        // TODO: handle exception
        return ResponseEntity.status(Response.SC_NOT_FOUND).build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody @Valid Product product){
        try {
            return productService.update(id, product);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }
    }

    // @GetMapping
    // public String findAll(Model model){
    //     try {
    //         model.addAttribute("list_product", productService.findAll()) ;

    //         return "products/index.html";
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         return "error.html";
    //     }
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        try {
            return productService.findById(id);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }
    }

    
}
