package com.example.demo.exception;

@SuppressWarnings("serial")
public class TaskNotFoundException extends RuntimeException {
	public TaskNotFoundException(Integer id) {
		// TODO Auto-generated constructor stub
		super("Task not found with id : " + id);
	}
}
