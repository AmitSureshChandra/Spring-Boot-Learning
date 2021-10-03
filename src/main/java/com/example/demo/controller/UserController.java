package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repositoriy.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/users")
	public Iterable<User> index(){
		return userRepo.findAll();
	}
	
	@PostMapping("/users")
	public User save(@RequestBody User user) {
		
//		validate user data
		
		userRepo.save(user);
		return user;
	}
}
