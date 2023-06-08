package com.example.EntranceIntern.User;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.example.EntranceIntern.Role.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User  {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    
    @Column(nullable = false, length = 128, unique = true)
    @NotNull() @Length(min = 5, max = 128)
    String username;

    @Email
    @Column(nullable = false, length = 128, unique = true)
    @NotNull() @Length(min = 5, max = 128)
    String email;


  
    @Column(nullable = false, length = 128)
    @NotNull() @Length(min = 6, max = 128)
    String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))

    private Set<Role> roles = new HashSet<>();
}
