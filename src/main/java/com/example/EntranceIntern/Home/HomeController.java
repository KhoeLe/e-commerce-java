package com.example.EntranceIntern.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EntranceIntern.Product.ProductServices;



@Controller
@RequestMapping
public class HomeController {
    @Autowired ProductServices productService;
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("list_product", productService.findAll()) ;
       return "products/index.html";
    }

    
}