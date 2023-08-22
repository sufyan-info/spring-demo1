package com.example.demo1.models;

import jakarta.persistence.*;

@Entity
@Table
public class ArticleTag {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_app_gen", sequenceName = "seq_app_user_id", allocationSize = 1)
    public @Id Long id;
}
