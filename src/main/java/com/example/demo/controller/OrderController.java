package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

	@PostMapping("/orders/{user_id}")
	public Order save(@RequestBody Order order, @PathVariable User user) {
        order.setUser(user);
        return orderService.save(order);
	}
}
