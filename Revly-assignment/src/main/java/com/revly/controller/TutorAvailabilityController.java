package com.revly.controller;

import com.revly.models.TutorAvailability;
import com.revly.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revly.services.TutorAvailabilityService;

import java.util.List;

@RestController
public class TutorAvailabilityController {
	
	@Autowired
	private TutorAvailabilityService tutorAvailabilityService;
	
	@GetMapping("/all-available-tutor")
	public ResponseEntity<Integer> countAvailableTutor(){
		int count = tutorAvailabilityService.countRealTimeAvailableTutor();
		return new ResponseEntity<>(count,HttpStatus.OK);
	}
	
	@GetMapping("/all-tutor")
	public ResponseEntity<List<Users>> availableTutorHandler(){
		List<Users> list = tutorAvailabilityService.realTimeAvailableTutor();
		return new ResponseEntity<List<Users>>(list,HttpStatus.OK);
	}
	
}
