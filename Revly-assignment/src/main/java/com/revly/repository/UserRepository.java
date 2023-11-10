package com.revly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revly.models.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	public Optional<Users> findByEmailId(String str);
}
