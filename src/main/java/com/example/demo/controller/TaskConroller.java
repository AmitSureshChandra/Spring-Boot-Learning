package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
public class TaskConroller {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public Iterable<Task> index(){
		return taskService.findAll();
	}
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task task) {
		return taskService.save(task);
	}
	
	@GetMapping("tasks/{id}")
	public Task data(@PathVariable Integer id){
		return taskService.getOne(id);
	}
	
	@PutMapping("/tasks/{id}")
	public Task update(@RequestBody Task newTask, @PathVariable Integer id){
		return taskService.update(newTask, id);
	}
	
	@DeleteMapping("tasks/{id}")
	public void delete(@PathVariable Integer id, HttpServletResponse response) {
		taskService.delete(id);
	}
}
