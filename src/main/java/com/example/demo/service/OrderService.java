package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.OrderBookedException;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Invoice;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repositoriy.InvoiceRepository;
import com.example.demo.repositoriy.ItemRepo;
import com.example.demo.repositoriy.OrderRepository;
import com.example.demo.repositoriy.UserRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ItemRepo itemRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    ModelMapper mapper;

    /**
     * Save Order
     * 
     * @param order
     * @param user_id
     * @return OrderDTO
     */

    public OrderDTO save(Order order, Long user_id) {
        order.setStatus(false);
        order.setUser(userService.getUser(user_id));
        orderRepository.save(order);
        return mapper.map(order, OrderDTO.class);
    }

    public OrderDTO getOrderDTO(Long order_id) {
        return mapper.map(getOrder(order_id), OrderDTO.class);
    }

    public Order getOrder(Long order_id) {
        return orderRepository.findById(order_id).orElseThrow(() -> {
            return new OrderNotFoundException(order_id);
        });
    }

    /**
     * Add Item to Order
     * 
     * @param order_id
     * @param item_id
     * @return Order
     */
    public Order addItem(Long order_id, Long item_id) throws OrderBookedException {
        Order order = getOrder(order_id);

        this.throwExceptionOnBooked(order, order_id);

        Item item = itemRepository.findById(item_id).get();

        List<Item> items = order.getItems();
        items.add(item);
        order.setItems(items);

        orderRepository.save(order);
        itemRepository.save(item);

        return order;
    }

    private void throwExceptionOnBooked(Order order, Long order_id) {
        if (order.getStatus()) {
            throw new OrderBookedException(order_id);
        }
        if (order.getStatus()) {
            throw new OrderBookedException(order_id);
        }
    }

    /**
     * Book Order
     * 
     * @param order_id
     * @return Order
     * @throws OrderBookedException
     */

    public Order bookOrder(Long order_id) {
        Order order = orderRepository.findById(order_id).get();
        order.setBookedAt(new Date());
        order.setStatus(true);

        Iterable<Item> items = order.getItems();

        Float total = 0f;
        for (Item item : items) {
            total += item.getPrice();
        }

        Invoice invoice = new Invoice();
        invoice.setTotal(total);
        order.setInvoice(invoice);
        orderRepository.save(order);
        invoiceRepository.save(invoice);
        return order;
    }

    public void removeItem(Long order_id, Long item_id) {
        Order order = getOrder(order_id);

        this.throwExceptionOnBooked(order, order_id);

        Item item = itemRepository.findById(item_id).get();

        List<Item> items = order.getItems();
        items.remove(item);
        order.setItems(items);

        orderRepository.save(order);
        itemRepository.save(item);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public void removeOrder(Long order_id){
        orderRepository.delete(getOrder(order_id));
    }
}
