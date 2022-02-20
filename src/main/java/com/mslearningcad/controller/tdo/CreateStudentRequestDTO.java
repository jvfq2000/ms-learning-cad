package com.mslearningcad.controller.tdo;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CreateStudentRequestDTO {
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String document;
	
	@NotNull
	private Date birthDate;
	
	@NotNull
	private UUID courseId;
}
