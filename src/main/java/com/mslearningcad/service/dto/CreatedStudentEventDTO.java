package com.mslearningcad.service.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CreatedStudentEventDTO {
	private UUID studentId;
	private String fullName;
	private UUID courseId;
}
