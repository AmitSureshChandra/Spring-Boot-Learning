package com.example.demo.repositoriy;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Task;

public interface TaskRepo extends CrudRepository<Task, Integer> {

}
