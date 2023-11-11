package com.revly.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revly.models.DoubtRequests;
import com.revly.models.TutorAvailability;
import com.revly.models.UserType;
import com.revly.models.Users;
import com.revly.repository.DoubtRequestRepository;
import com.revly.repository.TutorAvailabilityRepository;
import com.revly.repository.UserRepository;
import com.revly.services.DoubtRequestService;

@Service
public class DoubtRequestServiceImpl implements DoubtRequestService{
	
	
	@Autowired
	private DoubtRequestRepository doubtRequestRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TutorAvailabilityRepository tutorAvailabilityRepository;

	@Override
	public List<DoubtRequests> getAllDoubtHistory(Users student) {
		return doubtRequestRepository.findDoubtHistoryOfStudent( student);
	}

	@Override
	public String createDoubt(DoubtRequests doubtRequest,Long userId) {
		Optional<Users> u = userRepository.findById(userId);
		
		if(u.isPresent()) {
			DoubtRequests doubt = null;
			Users user = u.get();
			if(user.getUserType() == UserType.TUTOR) throw new RuntimeException("You are a teacher");
			
			List<Users> tutors = userRepository.findAllTutors();
			
			for(Users tutor:tutors) {
				
				
//				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
//				System.out.println(tutor);
//				System.out.println(tutor.getUserName());
//				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
				
				
				if(tutor.getLanguage().equalsIgnoreCase(user.getLanguage()) && tutor.getTutorExperties() == doubtRequest.getSubjectType() && user.getClassGrade().equals(tutor.getClassGrade())) {
					
//					System.out.println(tutor.getUserName());
//					System.out.println("line 54"); 
					
					Optional<TutorAvailability> tutAvail = tutorAvailabilityRepository.findByTutorEmail(tutor.getEmailId());
					
					System.out.println("line56");
					
					if(tutAvail.isPresent()) {
						
//						System.out.println("line58");
//						System.out.println(tutor.getUserName());
						
						
						TutorAvailability tutorAvailability = tutAvail.get();
						
//						System.out.println(tutorAvailability.getTutorEmail());
//						System.out.println("line 60");
						
						
						if(tutorAvailability.isAvailable()) {
							doubtRequest.setTutorEmail(tutor.getEmailId());
							doubtRequest.setStudent(user);
							doubtRequest.setTimeStamp(LocalDateTime.now());
							tutorAvailability.setAvailable(false);
							tutorAvailabilityRepository.save(tutorAvailability);
							doubtRequestRepository.save(doubtRequest);
							doubt = doubtRequest;
						}
					}
					
					
				}
			}
			if(doubt == null) {
				
				doubtRequest.setStudent(user);
				doubtRequest.setTimeStamp(LocalDateTime.now());
				doubtRequestRepository.save(doubtRequest);
				return "no tutor found at this moment";
			}else {
				return "your doubt will be resolved in some time";
			}
			
			
			
		}
		throw new RuntimeException("kldfjdlfjl");
	}
	

}
