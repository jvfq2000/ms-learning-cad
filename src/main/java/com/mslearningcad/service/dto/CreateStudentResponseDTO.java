package com.mslearningcad.service.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class CreateStudentResponseDTO {
	private UUID studentId;
}
