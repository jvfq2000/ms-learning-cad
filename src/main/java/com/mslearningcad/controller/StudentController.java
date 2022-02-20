package com.mslearningcad.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mslearningcad.controller.tdo.CreateStudentRequestDTO;
import com.mslearningcad.service.IStudentService;
import com.mslearningcad.service.dto.CreateStudentResponseDTO;
import com.mslearningcad.service.dto.StudentResponseDTO;

@RestController
@RequestMapping("/v1/student")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	@PostMapping
	public ResponseEntity<CreateStudentResponseDTO> create(@Valid @RequestBody CreateStudentRequestDTO course) {
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(this.studentService.create(course));
	}

	@GetMapping()
	public ResponseEntity<StudentResponseDTO> search(@PathVariable UUID studentId) {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(this.studentService.findById(studentId));
	}
}
