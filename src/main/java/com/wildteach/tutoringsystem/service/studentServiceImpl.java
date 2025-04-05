package com.wildteach.tutoringsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildteach.tutoringsystem.entity.wildteachEntity;
import com.wildteach.tutoringsystem.repository.wildteachRepository;


@Service

public class wildteachServiceImpl implements wildteachService{
	@Autowired
	private wildteachRepository studentRepository;
	@Override
	public wildteachEntity saveStudent(wildteachEntity student) {
	
		return studentRepository.save(student);
	}
	@Override
	public List<wildteachEntity> getAllStudents() {
		return studentRepository.findAll();
	}
	@Override
	public wildteachEntity getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	@Override
	public wildteachEntity updateStudent(Long id, wildteachEntity studentDetails) {
		wildteachEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			student.setLast_name(studentDetails.getLast_name());
			student.setFirst_name(studentDetails.getFirst_name());
			student.setMiddle_name(studentDetails.getMiddle_name());
			student.setBirth_date(studentDetails.getBirth_date());
			student.setGender(studentDetails.getGender());
			student.setEmail(studentDetails.getEmail());
			student.setContact_number(studentDetails.getContact_number());
			student.setAddress(studentDetails.getAddress());
			student.setUsername(studentDetails.getUsername());
			student.setCourse(studentDetails.getCourse());
			student.setYear_level(studentDetails.getYear_level());
			student.setRole(studentDetails.getRole());
			
			return studentRepository.save(student);
		}
		return null;
	}

}
