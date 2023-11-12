package com.revly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revly.models.DoubtRequests;
import com.revly.models.Users;
import com.revly.services.DoubtRequestService;
import com.revly.services.UserService;

@RestController
public class DoubtRequestController {

	@Autowired
	private DoubtRequestService doubtRequestService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/doubt-history/{id}")
	public ResponseEntity<List<DoubtRequests>> getAllDoubtHistory(@PathVariable Long id){
		Users student = userService.findById(id);
		List<DoubtRequests> doubtHistory = doubtRequestService.getAllDoubtHistory(student);
		return new ResponseEntity<List<DoubtRequests>>(doubtHistory,HttpStatus.OK);
	}
	
	@PostMapping("/ask-doubt/{id}")
	public ResponseEntity<String> askYourDoubt(@RequestBody DoubtRequests doubtRequests,@PathVariable Long id){
		String d = doubtRequestService.createDoubt(doubtRequests,id);
		
		return new ResponseEntity<String>(d,HttpStatus.CREATED);
	}
	
	@GetMapping("/all-doubt")
	public ResponseEntity<List<DoubtRequests>> allDoubtHandler(){
		List<DoubtRequests> allDoubt = doubtRequestService.getAllDoubt();
		return new ResponseEntity<List<DoubtRequests>>(allDoubt,HttpStatus.OK);
	}
	
}
