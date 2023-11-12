package com.revly.services;

import java.util.List;

import com.revly.exception.UserException;
import com.revly.models.Users;

public interface UserService {
	public Users registerUser(Users user) throws UserException;

	public Users findById(Long id) throws UserException;
	
	public List<Users> findAllTutors();
	
	public List<Users> findAllStudents();

	public Users findByEmailId(String name) throws UserException;
}
