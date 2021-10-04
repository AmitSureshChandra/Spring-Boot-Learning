package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public Iterable<User> index() {
		return userService.findAll();
	}

	@PostMapping("/users")
	public User save(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	@GetMapping("/users/{user_id}")
	public User get(@PathVariable Long user_id) {
		return userService.getUser(user_id);
	}

	@PutMapping("/users/{user_id}")
	public User update(@PathVariable Long user_id, @RequestBody User user) {
		return userService.update(user, user_id);
	}

	@DeleteMapping("/users/{user_id}")
	public void delete(@PathVariable Long user_id) {
		userService.delete(user_id);
	}
}
