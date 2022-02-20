package com.mslearningcad.service;

import org.springframework.stereotype.Service;

import com.mslearningcad.service.dto.CreatedStudentEventDTO;

@Service
public interface IEventService {
	public void send(CreatedStudentEventDTO createdStudentEventDTO);
}
