package com.revly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revly.models.Users;
import com.revly.repository.UserRepository;
import com.revly.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping("/hello")
	public String helloHandler() {
		return "Hello world";
	}
	
	@PostMapping("/register-user")
	public ResponseEntity<Users> registerUserHandler(@RequestBody Users user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUserType("ROLE_"+user.getUserType().toUpperCase());
		Users u = userService.registerUser(user);
		return new ResponseEntity<Users>(u, HttpStatus.CREATED);
	}
	
	@GetMapping("/all-tutors")
	public ResponseEntity<List<Users>> findAllTutorsHandler(){
		List<Users> tutors = userService.findAllTutors();
		return new ResponseEntity<List<Users>>(tutors,HttpStatus.OK);
	}
	@GetMapping("/all-students")
	public ResponseEntity<List<Users>> findAllStudentsHandler(){
		List<Users> tutors = userService.findAllStudents();
		return new ResponseEntity<List<Users>>(tutors,HttpStatus.OK);
	}
	
	
	@GetMapping("/signIn")
    public ResponseEntity<Users> getLoggedInUserDetailsHandler(Authentication auth){

        Users users= userService.findByEmailId(auth.getName());

        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }
	
}
