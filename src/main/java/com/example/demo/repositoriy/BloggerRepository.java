package com.example.demo.repositoriy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Blogger;

public interface BloggerRepository extends JpaRepository<Blogger, Long>{
	List<Blogger> findByAddress(String address);

	Iterable<Blogger> findByNameContainsOrAddressContains(String search, String search2);
	Iterable<Blogger> findFirst3ByNameContains(String search);
}
