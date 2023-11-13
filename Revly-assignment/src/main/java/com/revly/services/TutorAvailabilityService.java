package com.revly.services;

import com.revly.models.TutorAvailability;
import com.revly.models.Users;

import java.util.List;

public interface TutorAvailabilityService {

	public void updateTutorLastPingTime();
	public int countRealTimeAvailableTutor();
	public List<Users> realTimeAvailableTutor();
}
