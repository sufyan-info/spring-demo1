package com.example.demo1.repositories;

import com.example.demo1.models.UserArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<UserArticle, Long> {
    List<UserArticle> findUserArticlesByOwnerId(Long id);
}
