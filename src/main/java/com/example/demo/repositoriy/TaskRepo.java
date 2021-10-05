package com.example.demo.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}
