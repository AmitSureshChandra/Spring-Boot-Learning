package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.repositoriy.UserRepo;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

	@PostMapping("/orders/{user_id}")
	public OrderDTO save(@RequestBody Order order, @PathVariable Long user_id) {
       	return orderService.save(order, user_id);
	}
	
	@PostMapping("/orders/{order_id}/{item_id}")
	public Order saveItemOrder(@PathVariable Long order_id, @PathVariable Long item_id) {
		Order order = orderService.getOrder(order_id);
		return order;
	}
}
