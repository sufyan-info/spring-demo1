package com.example.demo1.controllers;

import com.example.demo1.dto.ArticleDto;
import com.example.demo1.dto.UserDto;
import com.example.demo1.models.AppUser;
import com.example.demo1.models.UserArticle;
import com.example.demo1.repositories.PostRepository;
import com.example.demo1.repositories.UserRepository;
import com.example.demo1.services.AppUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Resource AppUserService appUserService;
    private @Resource PostRepository postRepository;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser request){
        return appUserService.register(request);
    }

    @GetMapping
    public List<AppUser> getAllUsers(){
        return appUserService.getAllUsers();
    }
    
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId){
        AppUser user = appUserService.getById(userId);

        UserDto dto = UserDto.from(user);
        List<UserArticle> articles = postRepository.findUserArticlesByOwnerId(user.getId());
        List<ArticleDto> articleDtos = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++){
            ArticleDto articleDto = articles.get(i).toDto();
            articleDtos.add(articleDto);
        }
        dto.setArticles(articleDtos);
        return dto;
    }
}
