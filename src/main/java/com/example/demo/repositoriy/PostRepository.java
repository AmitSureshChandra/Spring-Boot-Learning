package com.example.demo.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
