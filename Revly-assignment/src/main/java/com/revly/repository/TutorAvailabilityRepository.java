package com.revly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revly.models.TutorAvailability;

public interface TutorAvailabilityRepository extends JpaRepository<TutorAvailability, Long>{

	public Optional<TutorAvailability> findByTutorEmail(String email);
} 
  