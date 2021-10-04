package com.example.demo.service;

import com.example.demo.dto.UserDTO;
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
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public Iterable<User> findAll() {
    	Iterable<User> users = userRepo.findAll();
        Iterable<UserDTO> userDTOs = new ArrayList<UserDTO>();
        modelMapper.map(users, userDTOs);
        System.out.println(users);
        System.out.println(userDTOs);
        
        return users;
    }
}
