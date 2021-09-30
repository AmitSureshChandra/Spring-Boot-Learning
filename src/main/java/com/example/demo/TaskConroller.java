package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskConroller {

	@Autowired
	private TaskRepo taskRepo;
	
	@GetMapping("/tasks")
	public Iterable<Task> index(){
		return taskRepo.findAll();
	}
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task task) {
		taskRepo.save(task);
		return task;
	}
	
	@GetMapping("tasks/{task}")
	public Task data(@PathVariable Integer id) {
		return taskRepo.findById(id).get();
	}
	
	@PutMapping("/tasks/{task}")
	public Task update(@RequestBody Task task) {
		taskRepo.save(task);
		return task;
	}
	
	@DeleteMapping("tasks/{task}")
	public void delete(@PathVariable Integer id) {
		taskRepo.deleteById(id);
	}
}
