package com.revly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revly.models.DoubtRequests;
import com.revly.models.Users;

public interface DoubtRequestRepository extends JpaRepository<DoubtRequests, Long>{
	
	@Query("SELECT d FROM DoubtRequests d WHERE d.student = :student ORDER BY d.timeStamp DESC")
	public List<DoubtRequests> findDoubtHistoryOfStudent(@Param("student") Users student);
}
