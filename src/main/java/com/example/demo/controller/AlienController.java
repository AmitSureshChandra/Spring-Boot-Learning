package com.example.demo.controller;

import com.example.demo.model.Alien;
import com.example.demo.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienController {
	
	@Autowired
	AlienService alienService;
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home2";
	}
	
	@PostMapping("/aliens")
	public Alien save(@RequestBody Alien alien) {
		return alienService.save(alien);
	}

	@GetMapping("/aliens")
	public Iterable<Alien> getAll() {
		return alienService.findAll();
	}
}
