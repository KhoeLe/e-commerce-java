package com.example.EntranceIntern.Order;

import java.lang.reflect.Array;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
@RequestMapping("order/cart")
public class OrderController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderServices orderServices;

    @GetMapping()
    public String CartPage (){
        return "order/cart.html";
    }
    

    @GetMapping("/checkout")
    public String CartCheckOutPage (Model model){

         // Get the currently logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userWhoOrdered = userRepository.getUserByUsername(authentication.getName());
        
        model.addAttribute("userWhoOrdered", userWhoOrdered);

        return "order/checkout.html";
    }


    @GetMapping("/completed")
    public String CartCompletedPage (Model model){

        // Get the currently logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userWhoOrdered = userRepository.getUserByUsername(authentication.getName());
        
        model.addAttribute("userWhoOrdered", userWhoOrdered);

        return "order/order_completed.html";
    }


    @GetMapping("/history")
    public String CartHistoryPage (Model model) throws JsonProcessingException{

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Order> orderHistory = orderServices.getOrderByUserId();

        model.addAttribute("order_history", orderHistory);
        return "order/order_history.html";
    }

    @GetMapping("/all")
    public String getAllHistory(Model model) {

        List<Order> orderHistory = orderServices.getAllOrder();
        

        model.addAttribute("history_list", orderHistory);

        return "order/admin_history.html";
        
    }






}
