package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Alien;
import com.example.demo.repositoriy.AlienRepo;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home2";
	}
	
	
//	@RequestMapping("/alien")
//	@ResponseBody
//	public String saveAlien(Alien alien) {
//		alien.setName("Amit");
//		alien.setId(1);
//		alienRepo.save(alien);
//		
//		return alien.toString();
//		
//	}
}
