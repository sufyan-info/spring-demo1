package com.example.demo1.models;

import com.example.demo1.dto.ArticleDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "articles")
@Data
public class UserArticle {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Id Long id;

    // Data Transfer Object -> DTO

    @ManyToOne
    private AppUser owner;

    private String title;
    private String body;

    @Transient
    public ArticleDto toDto(){
        return ArticleDto.from(this);
    }
}
