package com.example.demo.service;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.repositoriy.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    public Iterable<Task> findAll() {
        return taskRepo.findAll();
    }

    public Task getTask(Integer id) {
        return taskRepo.findById(id).orElseThrow(() -> {
            return new TaskNotFoundException(id);
        });
    }

    public Task save(Task task) {
        return taskRepo.save(task);
    }

    public Task update(Task newTask, Integer id) {
        Task oldTask = getTask(id);
        oldTask.setTitle(newTask.getTitle());
        oldTask.setStatus(newTask.getStatus());
        return taskRepo.save(oldTask);
    }

    public void delete(Integer id) {
        getTask(id);
        taskRepo.deleteById(id);
    }
}
