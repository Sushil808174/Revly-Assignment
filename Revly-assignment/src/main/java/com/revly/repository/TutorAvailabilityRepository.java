package com.revly.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revly.models.TutorAvailability;

public interface TutorAvailabilityRepository extends JpaRepository<TutorAvailability, Long>{

	public Optional<TutorAvailability> findByTutorEmail(String email);
	
	@Query("SELECT COUNT(*) FROM TutorAvailability t WHERE t.lastPingTime BETWEEN :stDate AND :enDate")
	public int countRealTimeAvailableTutorBetweenTime(@Param("stDate") LocalDateTime stDate, @Param("enDate") LocalDateTime enDate);
} 
  