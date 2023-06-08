package com.example.EntranceIntern.Product;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(nullable = false, length = 128)
    @NotNull() @Length(min = 5, max = 128)
    String name;


    String images;

    @Column(nullable = false)
    // @Length(min = 0, max = 9999)
    @NotNull()
    Float price;

    @Column(nullable = false, length = 9999)
    String description;

  
    
}
