package com.wildteach.tutoringsystem.service;


import java.util.List;

import com.wildteach.tutoringsystem.entity.wildteachEntity;


public interface wildteachService {
	public wildteachEntity saveStudent(wildteachEntity student);
	List<wildteachEntity> getAllStudents();
	public wildteachEntity getStudentById(Long id);
	public wildteachEntity updateStudent(Long id, wildteachEntity studentDetails); 

	
}
