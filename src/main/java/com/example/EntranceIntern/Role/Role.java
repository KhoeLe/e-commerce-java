package com.example.EntranceIntern.Role;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    @Column
    private String name;
}


