package com.mslearningcad.service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class StudentResponseDTO {
	private String fullName;
	private String document;
	private Date birthDate;
	private String courseName;
	private Boolean status;
}
