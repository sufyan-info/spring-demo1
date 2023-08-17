package com.example.demo1.controllers;

import com.example.demo1.models.AppUser;
import com.example.demo1.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Resource UserRepository userRepository;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser request){
        return userRepository.save(request);
    }

    @GetMapping
    public List<AppUser> getAllUsers(){
        return userRepository.findAll();
    }
}
