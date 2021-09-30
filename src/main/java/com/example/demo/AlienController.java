package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/alien")
	@ResponseBody
	public String saveAlien(Alien alien) {
		alien.setName("Amit");
		alien.setId(1);
		alienRepo.save(alien);
		
		return alien.toString();
		
	}
}
