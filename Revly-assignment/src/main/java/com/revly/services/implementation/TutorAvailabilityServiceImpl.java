package com.revly.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.revly.models.TutorAvailability;
import com.revly.models.Users;
import com.revly.repository.TutorAvailabilityRepository;
import com.revly.repository.UserRepository;
import com.revly.services.TutorAvailabilityService;

@Service
public class TutorAvailabilityServiceImpl implements TutorAvailabilityService{

	@Autowired
	private TutorAvailabilityRepository tutorAvailabilityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Async
	@Scheduled(fixedRate = 3000)
	public void updateTutorLastPingTimeInEveryThreeSec() {
		updateTutorLastPingTime();
	}
	
	
	@Override
	public void updateTutorLastPingTime() {
		List<Users> tutors = userRepository.findAllTutors();
		for(Users tutor : tutors) {
			Optional<TutorAvailability> opt = tutorAvailabilityRepository.findByTutorEmail(tutor.getEmailId());
			
			if(opt.isPresent()) {
				TutorAvailability tutorAvailability = opt.get();
				tutorAvailability.setLastPingTime(LocalDateTime.now());
				tutorAvailabilityRepository.save(tutorAvailability);
				
				System.out.println("+++++++++++++++++++++++++++++");
				System.out.println(tutorAvailability.getTutorEmail());
				System.out.println("+++++++++++++++++++++++++++++");
				
			}
		}
	}
	
//	@Async
	@Scheduled(fixedRate = 1000)
	public void updatingCountingRealTimeAvailableTutors() {
		int count = countRealTimeAvailableTutor();
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("Availabale tutor are : "+count);
		System.out.println("+++++++++++++++++++++++++++++");
	}

	@Override
	public int countRealTimeAvailableTutor() {
		return tutorAvailabilityRepository.countRealTimeAvailableTutorBetweenTime(LocalDateTime.now().minusSeconds(3), LocalDateTime.now());
	}

}
