package com.example.EntranceIntern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EntranceIntern.model.User;
import com.example.EntranceIntern.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired UserServices userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user){
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
