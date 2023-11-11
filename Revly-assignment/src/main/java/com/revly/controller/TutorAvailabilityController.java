package com.revly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revly.services.TutorAvailabilityService;

@RestController
public class TutorAvailabilityController {
	
	@Autowired
	private TutorAvailabilityService tutorAvailabilityService;
	
	@GetMapping("/all-available-tutor")
	public ResponseEntity<Integer> countAvailableTutor(){
		int count = tutorAvailabilityService.countRealTimeAvailableTutor();
		return new ResponseEntity<>(count,HttpStatus.OK);
	}
	
	
	
}
