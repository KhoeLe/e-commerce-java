package com.example.EntranceIntern.Role;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserRoleId implements Serializable {
    @Column(name = "user_id")
    private Integer user;

    @Column(name = "role_id")
    private Integer role;
}

