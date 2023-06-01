package com.example.EntranceIntern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EntranceIntern.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
