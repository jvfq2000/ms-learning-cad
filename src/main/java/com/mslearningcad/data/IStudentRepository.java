package com.mslearningcad.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mslearningcad.domain.Student;

@Repository
public interface IStudentRepository extends MongoRepository<Student, UUID> {
	@Query(value = "{'studentId': ?0}")
	public Student findByStudentId(UUID studentId);

	@Query(value = "{'courseName': ?0}")
	public List<Student> findByCourseName(String courseName);

	@Query(value = "{'courseId': ?0}")
	public List<Student> findByCourseId(UUID courseId);
}
