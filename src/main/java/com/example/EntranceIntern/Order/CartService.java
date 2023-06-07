package com.example.EntranceIntern.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.EntranceIntern.DTO.CartItemsDTO;
import com.example.EntranceIntern.Product.Product;
import com.example.EntranceIntern.Product.ProductRepository;
import com.example.EntranceIntern.User.User;
import com.example.EntranceIntern.User.UserRepository;

@Service
public class CartService {

    // @Autowired
    // private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;


    @Async
    public void addToCart(List<CartItemsDTO> cartItems ){
        List<OrderItem> orderItemList = new ArrayList<>();
        
       try {
         for(CartItemsDTO cartItem : cartItems){
            Integer quantity = cartItem.getQuantity();
            Long productId = cartItem.getProductId();
            Product product = productRepository.getProductById(productId);
            if (product != null) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(quantity);
                orderItemList.add(orderItem);
                System.out.println("My basket"+orderItem );
            }
        }

        saveCart(orderItemList);

       
       } catch (Exception e) {
            e.printStackTrace();
        // TODO: handle exception
       }
    }


    public void saveCart( List<OrderItem> orderItemList){
      try {
        
        Order order = new Order();
        float totalPrice = 0;

        order.setCreateDate(LocalDateTime.now());

        orderRepository.save(order);
        
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getProduct() != null) {
                
            totalPrice += orderItem.getProduct().getPrice() * orderItem.getQuantity();

            orderItem.setOrder(order);

            orderItemRepository.save(orderItem);
            }else{
                throw new IllegalArgumentException("Invalid quantity or product");
            }
           
        }

        order.setTotalPrice(totalPrice);

        

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userWhoOrdered = userRepository.getUserByUsername(authentication.getName());

        // TODO : save user to order
       Integer userId = userWhoOrdered.getId();
        User user = userRepository.findById(userId).orElse(null);
        order.setUser(user);

        order.setOrderItems(orderItemList);

        orderRepository.save(order);

      } catch (Exception e) {
        // TODO: handle exception
         e.printStackTrace();
      }
    }



}
