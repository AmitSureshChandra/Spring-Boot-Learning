package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.OrderBookedException;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public Iterable<Order> index() {
		return orderService.findAll();
	}

	@GetMapping("/orders/{order_id}")
	public Order getOrder(@PathVariable Long order_id) {
		return orderService.getOrder(order_id);
	}

	@PostMapping("/orders/{user_id}")
	public OrderDTO save(@RequestBody Order order, @PathVariable Long user_id) {
		return orderService.save(order, user_id);
	}

	@PostMapping("/orders/{order_id}/{item_id}")
	public Order saveItemOrder(@PathVariable Long order_id, @PathVariable Long item_id) throws OrderBookedException {
		Order order = orderService.getOrder(order_id);
		orderService.addItem(order_id, item_id);
		return order;
	}

	@DeleteMapping("/orders/{order_id}/{item_id}")
	public Order deleteItemFromOrder(@PathVariable Long order_id, @PathVariable Long item_id)
			throws OrderBookedException {
		Order order = orderService.getOrder(order_id);
		orderService.removeItem(order_id, item_id);
		return order;
	}

	@PostMapping("/orders/{order_id}/book")
	public Order saveItemOrder(@PathVariable Long order_id) throws OrderBookedException {
		// throws if order is already booked

		Order order = orderService.getOrder(order_id);

		if (order.getStatus()) {
			throw new OrderBookedException(order_id);
		}
		return orderService.bookOrder(order_id);
	}
}
