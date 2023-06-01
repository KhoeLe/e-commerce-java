package com.example.EntranceIntern.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Email
    @Column(nullable = false, length = 128, unique = true)
    @NotNull() @Length(min = 5, max = 128)
    String email;


    @Column(nullable = false, length = 128)
    @NotNull() @Length(min = 6, max = 128)
    String password;
}
