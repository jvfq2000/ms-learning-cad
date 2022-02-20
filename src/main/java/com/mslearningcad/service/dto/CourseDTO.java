package com.mslearningcad.service.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CourseDTO {
	private UUID courseId;
	private String courseName;
	private Boolean status;
	private Date createdOn;
}
