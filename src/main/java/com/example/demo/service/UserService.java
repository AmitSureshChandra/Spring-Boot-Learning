package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repositoriy.UserRepo;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    public UserDTO save(User user) {
        userRepo.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(() -> {
            return new UserNotFoundException(id);
        });
    }

    public User update(User newUser, Long id) {
        User user = getUser(id);
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        user.setMobile(newUser.getMobile());
        return user;
    }

    public void delete(Long user_id) {
        userRepo.delete(getUser(user_id));
    }
}
