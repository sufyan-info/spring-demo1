package com.example.demo1.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="app_users")
@Data
public class AppUser {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Id Long id;

    private String email;
    private String name;
}
