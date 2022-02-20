package com.mslearningcad.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mslearningcad.controller.tdo.CreateStudentRequestDTO;
import com.mslearningcad.service.dto.CreateStudentResponseDTO;
import com.mslearningcad.service.dto.StudentResponseDTO;

@Service
public interface IStudentService {
	public CreateStudentResponseDTO create(CreateStudentRequestDTO student);
	public StudentResponseDTO findById(UUID studentId);
}
