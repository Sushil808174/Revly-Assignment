package com.revly.services.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revly.models.Users;
import com.revly.repository.UserRepository;
import com.revly.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users registerUser(Users user) {
		userRepository.save(user);
		return user;
//		Optional<Users> opt = userRepository.findByEmailId(user.getEmailId());
//		if(opt.isEmpty()) {
//			userRepository.save(opt.get());
//			return user;
//		}
//		throw new RuntimeException("already");
	}

	@Override
	public Users findById(Long id) {
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isEmpty()) {
			throw new RuntimeException("found");
		}else {
			return opt.get();
		}
	}

}
