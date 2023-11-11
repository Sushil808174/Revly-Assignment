package com.revly.services;

import java.util.List;

import com.revly.models.Users;

public interface UserService {
	public Users registerUser(Users user);

	public Users findById(Long id);
	
	public List<Users> findAllTutors();
	
	public List<Users> findAllStudents();
}
