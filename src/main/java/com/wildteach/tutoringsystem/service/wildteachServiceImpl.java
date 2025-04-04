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

}
