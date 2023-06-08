package com.example.EntranceIntern.Product;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    

    @Autowired ProductRepository repo;


    public List<Product> findAll(){

        return repo.findAll();
    }

    public Product create(Product product){

        return repo.save(product);
       

        // URI uri = URI.create("http://localhost:8080/api/v1/products/" + newProduct.getId());                
    }

    public Product  findById(Long id){

        Product product = repo.findById(id).get();

        return product;
        
    }

    public Product update(Product product){

         Product find = findById(product.getId());
        // Product newProduct = repo.findById(id).get();
        if(find != null){
             find.setName(product.getName());
            find.setPrice(product.getPrice());

        }
       return repo.save(find);

    }

    private Product get(Long id) {
        return null;
    }

    public ResponseEntity<Product> delete(Long id){

        Product product = repo.findById(id).get();

        repo.delete(product);

        return ResponseEntity.ok(product);
    }




}
