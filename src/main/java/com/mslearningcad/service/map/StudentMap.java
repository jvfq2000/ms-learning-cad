package com.mslearningcad.service.map;

import com.mslearningcad.domain.Student;
import com.mslearningcad.service.dto.StudentResponseDTO;

public class StudentMap {
	public static StudentResponseDTO toDTO(Student student) {
		String courseName = "";
			
		return new StudentResponseDTO(
			student.getFirstName() + " " + student.getLastName(),
			student.getDocument(),
			student.getBirthdate(),
			courseName,
			student.getStatus()
		);
	}
}
