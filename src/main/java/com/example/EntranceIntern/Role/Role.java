package com.example.EntranceIntern.Role;

import jakarta.persistence.*;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    
    @Column
    private String name;

    public String getName() {
        return this.name;
    }
}


