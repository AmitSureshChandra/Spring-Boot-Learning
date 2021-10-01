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
	
	@GetMapping("tasks/{id}")
	public Task data(@PathVariable Integer id) {
		return taskRepo.findById(id).orElseThrow(() -> {
			return new TaskNotFoundException(id);
		});
	}
	
	@PutMapping("/tasks/{id}")
	public Task update(@RequestBody Task newTask, @PathVariable Integer id) {
		return taskRepo.findById(id).map(oldTask -> {
			oldTask.setTitle(newTask.getTitle());
			oldTask.setStatus(newTask.getStatus());
			return taskRepo.save(oldTask);
		}).orElseGet(() -> {
			newTask.setId(id);
			return taskRepo.save(newTask);
		});
	}
	
	@DeleteMapping("tasks/{id}")
	public void delete(@PathVariable Integer id) {
		taskRepo.deleteById(id);
	}
}
