package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.TaskConroller;

@SpringBootTest
class FirstServiceApplicationTests {
	
	@Autowired
	private TaskConroller taskContrConroller;

	@Test
	void contextLoads() throws Exception{
		assertThat(taskContrConroller).isNotNull();
	}

}
