package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.exception.TaskNotFoundException;

@ControllerAdvice
public class TaskNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String taskNotFoundException(TaskNotFoundException exception ) {
		return exception.getMessage();
	}
}
