package com.example.POC2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.POC2.beans.UserLogin;


public interface UserRepository  extends JpaRepository<UserLogin, String>{

	Optional<UserLogin> findByUserName(String userName);
	
	

}
