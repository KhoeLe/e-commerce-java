package com.example.EntranceIntern.Product;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    

    @Autowired ProductServices productService;

    @GetMapping
    public String viewProductList (Model model){
        // get all product
        model.addAttribute("productList",   productService.findAll());
      
        return "products/list.html";
    }

    @GetMapping("/create")
    public String viewProductCreate(Model model){

        model.addAttribute("product", new Product());

        return "products/create.html";
    }

    @PostMapping("/create")
    public String create( @Valid Product product , Model model){
    
        Product productCreated = productService.create(product);


        model.addAttribute("product", productCreated);

        return "products/list.html";
       
    }

    @GetMapping("/{id}")
    public String viewProductEdit(@PathVariable Long id , Model model){

        Product product = productService.findById(id);
        
        model.addAttribute("product", product);

         return "products/edit.html";
    }

    @PutMapping("/{id}")
    public String update(@Valid Product product ,@RequestParam MultipartFile imageProduct, Model model){


        // model.addAttribute("product", productUpdated);
        System.out.println(imageProduct);

         if(imageProduct != null && imageProduct.getSize() > 0){
            {
            try {
                File saveFile = new ClassPathResource("static/images").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + product.getImages());
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         }

         productService.update(product);

        return "products/list.html";
        
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Long id){

        productService.delete(id);


        // return "redirect:/admin/products";
        // return "redirect products/list.html";

        return "redirect:/";
    }


    
}
