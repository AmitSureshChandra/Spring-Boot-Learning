package com.example.demo.service;

import com.example.demo.model.Alien;
import com.example.demo.repositoriy.AlienRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlienService {
    
    @Autowired
    private AlienRepo alienRepo;

    public Iterable<Alien> findAll() {
        return alienRepo.findAll();
    }

    public Alien save(Alien alien){
        return alienRepo.save(alien);
    }
}
