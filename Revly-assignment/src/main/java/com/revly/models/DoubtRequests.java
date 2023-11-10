package com.revly.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	
	private String doubtText;
	
	private LocalDateTime timeStamp;
}
