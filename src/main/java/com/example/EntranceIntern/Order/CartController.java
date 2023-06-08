package com.example.EntranceIntern.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EntranceIntern.DTO.CartItemsDTO;
import com.example.EntranceIntern.User.User;
import com.example.EntranceIntern.User.UserRepository;

@RestController
@RequestMapping("/api/v1/order/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;


    @PostMapping()
    @ResponseBody()
    public ResponseEntity<String> addToCart(@RequestBody List<CartItemsDTO> cartItems) {

        try {
            cartService.addToCart(cartItems );
            return ResponseEntity.status(HttpStatus.CREATED).body( "Add to cart successfully");
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Add to cart failed");
        }
    }

    
}
