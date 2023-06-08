package com.example.EntranceIntern.Auth;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EntranceIntern.Role.Role;
import com.example.EntranceIntern.Role.RoleRepository;
import com.example.EntranceIntern.User.User;

@Service
public class AuthServices {
   
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User save(com.example.EntranceIntern.User.User userDto) {

      Optional<Role> roleOptional = roleRepository.findById(2);
    
    if (roleOptional.isPresent()) {
        Role role = roleOptional.get();

        userDto.getRoles().add(role);

        return authRepository.save(userDto);
    } else {
        throw new IllegalArgumentException("Role not found with role_id 2");
    }
    }
}

