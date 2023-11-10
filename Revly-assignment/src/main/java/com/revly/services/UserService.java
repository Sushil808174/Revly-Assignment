package com.revly.services;

import com.revly.models.Users;

public interface UserService {
	public Users registerUser(Users user);

	public Users findById(Long id);
}
