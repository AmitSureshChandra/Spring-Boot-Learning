package com.example.demo.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long item_id) {
        super("item not found with id " + item_id);
    }
}
