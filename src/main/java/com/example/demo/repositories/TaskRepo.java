package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Task;

public interface TaskRepo extends CrudRepository<Task, Integer> {

}
