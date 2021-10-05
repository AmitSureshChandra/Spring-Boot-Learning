package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Blogger;
import com.example.demo.repositoriy.BloggerRepository;

@Service
public class BloggerService {
	
	@Autowired
	BloggerRepository bloggerRepository;

	public Iterable<Blogger> findAll() {
		// TODO Auto-generated method stub
		return bloggerRepository.findAll();
	}

	public Blogger save(Blogger blogger) {
		// TODO Auto-generated method stub
		System.out.println(blogger.getAddress());
		return bloggerRepository.save(blogger);
	}

	public Iterable<Blogger> findByNameContains(String search) {
		// TODO Auto-generated method stub
		return bloggerRepository.findByNameContainsOrAddressContains(search,search);
	}

}
