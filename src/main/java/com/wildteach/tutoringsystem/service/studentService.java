package com.wildteach.tutoringsystem.service;

import java.util.List;
import com.wildteach.tutoringsystem.entity.studentEntity;

public interface studentService {
	studentEntity saveStudent(studentEntity student);

	List<studentEntity> getAllStudents();

	studentEntity getStudentById(Long id);

	studentEntity updateStudent(Long id, studentEntity studentDetails);

	boolean deleteStudent(Long id);
}
