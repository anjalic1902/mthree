package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String role;

    // Getters and Setters
}
