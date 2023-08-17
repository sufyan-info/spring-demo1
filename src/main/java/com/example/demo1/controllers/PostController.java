package com.example.demo1.controllers;

import com.example.demo1.dto.ArticleDto;
import com.example.demo1.models.UserArticle;
import com.example.demo1.repositories.PostRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/articles")
@RestController
public class PostController {
    private @Resource PostRepository postRepository;

    @PostMapping
    public ArticleDto createArticle(@RequestBody ArticleDto dto){
        return postRepository.save(dto.toEntity()).toDto();
    }

    @GetMapping("/{userId}")
    public List<ArticleDto> getArticles(@PathVariable Long userId){
        return postRepository.findUserArticlesByOwnerId(userId)
                .stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
