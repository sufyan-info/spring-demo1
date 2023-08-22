package com.example.demo1.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class ArticleCategory {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_app_gen", sequenceName = "seq_app_user_id", allocationSize = 1)
    public @Id Long id;
    private String name;
}
