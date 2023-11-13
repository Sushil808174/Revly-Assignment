package com.revly.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doubt_Req")
public class DoubtRequests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doubtId;
	
	@ManyToOne
	@JoinColumn(name = "std_id")
	private Users student;
	
	@Enumerated(EnumType.STRING)
	private SubjectType subjectType;

	@Column(nullable = false)
	private String doubtText;
	
	private LocalDateTime timeStamp;
	
	private String tutorEmail;
}
