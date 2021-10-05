package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Blogger;
import com.example.demo.service.BloggerService;

@RestController
public class BloggerController {
	
	@Autowired
	private BloggerService bloggerService;

	@GetMapping("/bloggers")
	public Iterable<Blogger> getAll( @RequestParam(required = false, defaultValue = "") String search){
		
		if(!search.equals("")) {
			System.out.println("I am called");
			return bloggerService.findByNameContains(search);
		}
		
		Iterable<Blogger> bloggers = bloggerService.findAll();
		
		return bloggers;
	}
	
	@PostMapping("/bloggers")
	public Blogger save(@RequestBody Blogger blogger) {
		bloggerService.save(blogger);
		return blogger;
	}

}
