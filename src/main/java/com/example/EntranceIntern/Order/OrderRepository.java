package com.example.EntranceIntern.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EntranceIntern.User.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
      List<Order> findByUserIdAndUserUsername(Integer userId, String username);

      boolean existsByUser(User userWhoOrdered);

}