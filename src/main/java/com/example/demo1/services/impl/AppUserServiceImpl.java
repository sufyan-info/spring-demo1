package com.example.demo1.services.impl;

import com.example.demo1.models.AppUser;
import com.example.demo1.repositories.UserRepository;
import com.example.demo1.services.AppUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {
    private @Resource UserRepository userRepository;

    @Override
    public AppUser getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow();
    }

    @Override
    public AppUser register(AppUser request) {
        return userRepository.save(request);
    }

    @Override
    public AppUser signIn(AppUser request) {
        return null;
    }

    @Override
    public AppUser update(AppUser request) {
        return null;
    }

    @Override
    public void delete(AppUser request) {

    }

    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }
}
