package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.repositoriy.ItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepository;

    public Item getItem(Long item_id) {
        return itemRepository.findById(item_id).orElseThrow(() -> {
            return new ItemNotFoundException(item_id);
        });
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void remove(Long item_id) {
        itemRepository.delete(getItem(item_id));
    }

    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item update(Item newItem, Long item_id) {
        Item item = getItem(item_id);

        item.setName(newItem.getName());
        item.setPrice(newItem.getPrice());

        itemRepository.save(item);

        return item;
    }

}
