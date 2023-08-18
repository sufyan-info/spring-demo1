package com.example.demo1.services;

import com.example.demo1.models.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser getById(Long userId);

    AppUser register(AppUser request);

    AppUser signIn(AppUser request);

    AppUser update(AppUser request);

    void delete(AppUser request);

    List<AppUser> getAllUsers();
}
