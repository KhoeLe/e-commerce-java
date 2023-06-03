package com.example.EntranceIntern.Order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    
    @GetMapping()
   public String CartPage (Model model){
        return "products/cart.html";
    }

    @GetMapping("/checkout")
    public String CartCheckOutPage (){
        return "products/checkout.html";
    }


}
