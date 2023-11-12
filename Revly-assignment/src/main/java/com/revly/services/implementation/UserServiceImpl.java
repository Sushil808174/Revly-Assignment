package com.revly.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revly.exception.UserException;
import com.revly.models.TutorAvailability;
import com.revly.models.Users;
import com.revly.repository.TutorAvailabilityRepository;
import com.revly.repository.UserRepository;
import com.revly.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TutorAvailabilityRepository tutorAvailabilityRepository;
	

	@Override
	public Users registerUser(Users user) throws UserException{
		Optional<Users> opt = userRepository.findByEmailId(user.getEmailId());
		 if (opt.isPresent()) {
		        throw new UserException("Email is already in use");
		    }

		    userRepository.save(user);

		    // If the user is a tutor, save TutorAvailability
		    if (user.getUserType().equalsIgnoreCase("ROLE_TUTOR")) {
		        TutorAvailability tutorAvailability = new TutorAvailability();
		        tutorAvailability.setTutorEmail(user.getEmailId());
		        tutorAvailability.setLastPingTime(LocalDateTime.now());
		        tutorAvailabilityRepository.save(tutorAvailability);
		    }

		    return user;
	}

	@Override
	public Users findById(Long id) throws UserException{
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isEmpty()) {
			throw new UserException("Not found");
		}else {
			return opt.get();
		}
	}

	@Override
	public List<Users> findAllTutors() {
		List<Users> tutors = userRepository.findAllTutors();
		return tutors;
	}

	@Override
	public List<Users> findAllStudents() {
		List<Users> students = userRepository.findAllStudents();
		return students;
	}

	@Override
	public Users findByEmailId(String name) throws UserException {
		Optional<Users> opt = userRepository.findByEmailId(name);
		if(opt.isPresent()) {
			Users user = opt.get();
			return user;
		}
		throw new UserException("User not found ");
		
	}

}
