package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/items")
	public Item save(@RequestBody Item item) {
		itemService.save(item);
		return item;
	}

	@PutMapping("/items/{item_id}")
	public Item update(@RequestBody Item item, @PathVariable Long item_id) {
		return itemService.update(item, item_id);
	}

	@DeleteMapping("/items/{item_id}")
	public void delete(@PathVariable Long item_id) {
		itemService.remove(item_id);
	}

	@GetMapping("/items")
	public Iterable<Item> index(HttpServletRequest request) {

		System.out.println(request.getParameter("search"));
		System.out.println(request.getAttribute("search"));
		return itemService.findAll();
	}

	@GetMapping("/items/{item_id}")
	public Item index(@PathVariable Long item_id) {
		return itemService.getItem(item_id);
	}
}
