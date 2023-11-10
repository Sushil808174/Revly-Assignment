package com.revly.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revly.models.DoubtRequests;
import com.revly.models.Users;
import com.revly.repository.DoubtRequestRepository;
import com.revly.repository.UserRepository;
import com.revly.services.DoubtRequestService;

@Service
public class DoubtRequestServiceImpl implements DoubtRequestService{
	
	
	@Autowired
	private DoubtRequestRepository doubtRequestRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<DoubtRequests> getAllDoubtHistory(Users student) {
		return doubtRequestRepository.findDoubtHistoryOfStudent( student);
	}

	@Override
	public DoubtRequests createDoubt(DoubtRequests doubtRequest,Long id) {
		Optional<Users> u = userRepository.findById(id);
		if(u.isPresent()) {
			Users user = u.get();
			doubtRequest.setStudent(user);
			doubtRequest.setTimeStamp(LocalDateTime.now());
			doubtRequestRepository.save(doubtRequest);
			return doubtRequest;
		}
		throw new RuntimeException("kldfjdlfjl");
	}

}
