package com.example.demo.repositoriy;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepo extends CrudRepository<User, Long>  {

}
