package com.wildteach.tutoringsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.repository.studentRepository;


@Service

public class studentServiceImpl implements studentService{
	@Autowired
	private studentRepository studentRepository;
	@Override
	public studentEntity saveStudent(studentEntity student) {
	
		return studentRepository.save(student);
	}
	@Override
	public List<studentEntity> getAllStudents() {
		return studentRepository.findAll();
	}
	@Override
	public studentEntity getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	

}
