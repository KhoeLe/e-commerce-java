package com.example.EntranceIntern.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.EntranceIntern.User.User;
import com.example.EntranceIntern.User.UserRepository;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Order> getOrderByUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userWhoOrdered = userRepository.getUserByUsername(authentication.getName());
        Integer userId = userWhoOrdered.getId();
        String username = userWhoOrdered.getUsername();
                 
        return orderRepository.findByUserIdAndUserUsername(userId,username);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
