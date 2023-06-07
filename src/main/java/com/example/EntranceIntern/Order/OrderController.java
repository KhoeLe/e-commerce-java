package com.example.EntranceIntern.Order;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EntranceIntern.User.User;
import com.example.EntranceIntern.User.UserRepository;

@Controller
@RequestMapping("order/cart")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String CartPage (){
        return "products/cart.html";
    }
    

    @GetMapping("/checkout")
    public String CartCheckOutPage (Model model){

         // Get the currently logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userWhoOrdered = userRepository.getUserByUsername(authentication.getName());
        
        model.addAttribute("userWhoOrdered", userWhoOrdered);

        return "products/checkout.html";
    }


    @GetMapping("/completed")
    public String CartCompletedPage (Model model){

        // Get the currently logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userWhoOrdered = userRepository.getUserByUsername(authentication.getName());
        
        model.addAttribute("userWhoOrdered", userWhoOrdered);

        return "order/order_completed.html";
    }






}
