package com.IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IMS.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
