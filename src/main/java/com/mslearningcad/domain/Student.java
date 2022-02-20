package com.mslearningcad.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter @Setter
public class Student {
	@Id
	private String id;
	
	private UUID studentId;
	private String firstName;
	private String lastName;
	private String document;
	private Date birthdate;
	private Boolean status;
	private Date createdOn;
	
	private UUID courseId;
	
	public Student(String firstName, String lastName, String document, Date birthdate, UUID courseId) {
		this.studentId = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.document = document;
		this.birthdate = birthdate;
		this.status = true;
		this.createdOn = new Date();
		
		this.courseId = courseId;
	}
}
