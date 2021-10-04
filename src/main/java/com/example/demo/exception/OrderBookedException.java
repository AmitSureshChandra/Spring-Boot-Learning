package com.example.demo.exception;

@SuppressWarnings("serial")
public class OrderBookedException extends RuntimeException {

	public OrderBookedException(Long order_id) {
		// TODO Auto-generated constructor stub
		super("Order is placed with id : " + order_id);
	}
	
}
