package com.mslearningcad.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mslearningcad.service.IEventService;
import com.mslearningcad.service.dto.CreatedStudentEventDTO;

@Service
public class EventService implements IEventService {
	private final KafkaTemplate<String, CreatedStudentEventDTO> kafkaTemplate;
	private final String topic;
	
	public EventService(
		@Value("${topic.name}") String topic,
		KafkaTemplate<String, CreatedStudentEventDTO> kafkaTemplate
	) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	@Override
	public void send(CreatedStudentEventDTO createdStudentEventDTO) {
		kafkaTemplate.send(topic, createdStudentEventDTO);
	}
}
