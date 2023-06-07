package com.example.EntranceIntern.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EntranceIntern.User.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Các phương thức tương tác với cơ sở dữ liệu liên quan đến đơn hàng

      List<Order> findByUserId(Long userId);

      boolean existsByUser(User userWhoOrdered);
}