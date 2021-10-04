package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("User with id "+ id + " is not exists");
    }
}
