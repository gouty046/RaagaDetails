package com.example.demo.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUsername(String username);
}
	

