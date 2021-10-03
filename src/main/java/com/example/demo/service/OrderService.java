package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repositoriy.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }
}
