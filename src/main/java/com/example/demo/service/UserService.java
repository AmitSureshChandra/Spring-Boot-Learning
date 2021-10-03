package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositoriy.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        userRepo.save(user);
        return user;
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }
}
