package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
	
}
