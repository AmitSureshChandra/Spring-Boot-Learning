package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.repositoriy.ItemRepo;

@RestController
public class ItemController {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@PostMapping("/items")
	public Item save(@RequestBody Item item) {
		itemRepo.save(item);
		return item;
	}

	@GetMapping("/items")
	public Iterable<Item> index(){
		return itemRepo.findAll();
	}
}
