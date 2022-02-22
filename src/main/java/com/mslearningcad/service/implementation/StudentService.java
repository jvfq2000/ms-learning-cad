package com.mslearningcad.service.implementation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mslearningcad.controller.tdo.CreateStudentRequestDTO;
import com.mslearningcad.data.IStudentRepository;
import com.mslearningcad.domain.Student;
import com.mslearningcad.service.IStudentService;
import com.mslearningcad.service.dto.CourseDTO;
import com.mslearningcad.service.dto.CreateStudentResponseDTO;
import com.mslearningcad.service.dto.CreatedStudentEventDTO;
import com.mslearningcad.service.dto.StudentResponseDTO;
import com.mslearningcad.service.map.StudentMap;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private EventService eventService;
	
	@Override
	public CreateStudentResponseDTO create(CreateStudentRequestDTO student) {
		RestTemplate restTemplate = new RestTemplate();
		
		CourseDTO[] courses = restTemplate.getForObject(
			"http://localhost:8081/v1/course?courseId="+student.getCourseId(),
			CourseDTO[].class
		);
		
		if (courses.length == 0) {
			throw new EmptyResultDataAccessException(1);
		}
		
		Student studentCreated = this.studentRepository.save(
			new Student(
				student.getFirstName(),
				student.getLastName(),
				student.getDocument(),
				student.getBirthDate(),
				student.getCourseId()
			)
		);
		
		this.eventService.send(
			new CreatedStudentEventDTO(
				studentCreated.getStudentId(),
				studentCreated.getFirstName()+" "+studentCreated.getLastName(),
				studentCreated.getCourseId()
			)
		);
		
		return new CreateStudentResponseDTO(studentCreated.getStudentId());
	}

	@Override
	public StudentResponseDTO findById(UUID studentId) {
		Student student =  this.studentRepository.findByStudentId(studentId);
		
		if (student == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return StudentMap.toDTO(student);
	}
}
