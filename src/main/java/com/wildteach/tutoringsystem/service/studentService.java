package com.wildteach.tutoringsystem.service;


import java.util.List;

import com.wildteach.tutoringsystem.entity.studentEntity;


public interface studentService {
	public studentEntity saveStudent(studentEntity student);
	List<studentEntity> getAllStudents();
	public studentEntity getStudentById(Long id);
	public studentEntity updateStudent(Long id, studentEntity studentDetails); 

	
}
