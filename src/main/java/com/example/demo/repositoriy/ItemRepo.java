package com.example.demo.repositoriy;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Item;

public interface ItemRepo extends CrudRepository<Item, Long> {
    Iterable<Item> findByName(String name);
}
