package com.example.demo1.models;

import com.example.demo1.dto.ArticleDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class UserArticle {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_app_gen", sequenceName = "seq_app_user_id", allocationSize = 1)
    private @Id Long id;

    // Data Transfer Object -> DTO

    @ManyToOne
    private AppUser owner;

    @OneToOne
    private ArticleCategory category;

    @OneToMany
    private List<ArticleTag> tags;

    private String title;
    private String body;

    @Transient
    public ArticleDto toDto(){
        return ArticleDto.from(this);
    }
}
