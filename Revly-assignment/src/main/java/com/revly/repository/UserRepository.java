package com.revly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revly.models.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	public Optional<Users> findByEmailId(String str);
	
	 @Query("SELECT u FROM Users u WHERE u.userType = 'ROLE_TUTOR'")
	  public List<Users> findAllTutors();
	 
	 @Query("SELECT u FROM Users u WHERE u.userType = 'ROLE_STUDENT'")
	 public List<Users> findAllStudents();
	
}
