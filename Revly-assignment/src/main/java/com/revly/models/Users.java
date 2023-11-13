package com.revly.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false)
	private String userName;

	@Column(unique = true,nullable = false)
	@Email(message = "email should be valid")
	private String emailId;

	@Column(nullable = false)
	private String password;
	
	private String userType;
	
//	for tutor
	@Enumerated(EnumType.STRING)
	private SubjectType tutorExperties;

	@Column(nullable = false)
	private String language;

	@Column(nullable = false)
	private String classGrade;
	
}
