package com.revly.services;

import java.util.List;

import com.revly.models.DoubtRequests;
import com.revly.models.Users;

public interface DoubtRequestService {
	public List<DoubtRequests> getAllDoubtHistory(Users student);
	public String createDoubt(DoubtRequests doubtRequest, Long id);
	
}
