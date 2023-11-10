package com.revly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revly.models.Users;
import com.revly.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("hello")
	public String helloHandler() {
		return "Hello world";
	}
	
	@PostMapping("/register-user")
	public ResponseEntity<Users> registerUserHandler(@RequestBody Users user){
		Users u = userService.registerUser(user);
		return new ResponseEntity<Users>(u, HttpStatus.CREATED);
	}
	
	
}
