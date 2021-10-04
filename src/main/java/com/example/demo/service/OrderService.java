package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repositoriy.ItemRepo;
import com.example.demo.repositoriy.OrderRepository;
import com.example.demo.repositoriy.UserRepo;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private ItemRepo itemRepository; 
    
    @Autowired
    ModelMapper mapper;

    public OrderDTO save(Order order, Long user_id) {

        User user = userRepo.findById(user_id).orElseThrow(() -> {
            return new OrderNotFoundException(user_id);
        });
        
        order.setBookedAt(new Date());
        order.setStatus(false);
        order.setUser(user);

        orderRepository.save(order);
        
        OrderDTO orderDTO = mapper.map(order, OrderDTO.class);
        
        return orderDTO;
    }
    
    public OrderDTO getOrderDTO(Long order_id) {
    	return mapper.map(getOrder(order_id), OrderDTO.class);
    }
    
    public Order getOrder(Long order_id) {
    	return orderRepository.findById(order_id).get();
    }
    
    
    public Order addItem(Long order_id, Long item_id) {
    	Order order = getOrder(order_id);
    	Item item = itemRepository.findById(item_id).get();
    	
    	List<Item> items = order.getItems();
    	items.add(item);
    	order.setItems(items);
    	
    	orderRepository.save(order);
    	itemRepository.save(item);
    	
    	return order;
    }
}
