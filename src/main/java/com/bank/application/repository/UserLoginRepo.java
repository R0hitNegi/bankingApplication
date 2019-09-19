package com.bank.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.application.model.Users;

public interface UserLoginRepo extends JpaRepository<Users, Integer> {

	@Query(value = "select * from user_details u where u.username=:username", nativeQuery = true)
	Users getByUserName(String username);

	/*
	 * @Query("from Users u where u.userName = ?1") public Users
	 * getUserByUsername(String userName);
	 */

	Users findByUsername(String username);
	
	@Query(value = "select * from user_details u where u.user_email=:email", nativeQuery = true)
	Users getByEmailId(String email);
}
