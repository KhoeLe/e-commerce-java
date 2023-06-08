package com.example.EntranceIntern.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EntranceIntern.User.User;

@Repository
public interface AuthRepository  extends JpaRepository<User, Integer>{

    
}
