package com.example.demo1.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="app_users")
@Data
public class AppUser {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_app_gen", sequenceName = "seq_app_user_id", allocationSize = 1)
    private @Id Long id;

    private String email;
    private String name;

    public AppUser(){}

    public AppUser(Long id){
        this.id = id;
    }
}
