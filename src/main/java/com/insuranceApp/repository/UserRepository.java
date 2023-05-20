package com.insuranceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuranceApp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
