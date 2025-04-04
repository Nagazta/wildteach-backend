package com.wildteach.tutoringsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildteach.tutoringsystem.entity.wildteachEntity;
import com.wildteach.tutoringsystem.service.wildteachService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class wildteachController {
	@Autowired
	private wildteachService studentService;
	
	// Endpoint to add a new student
	@PostMapping("/add")
	public String addStudent(@RequestBody wildteachEntity student) {
		studentService.saveStudent(student);
		return "New student is added";
	}
	// Endpoint to get all students
	@GetMapping("/All")
	public List<wildteachEntity> getAllStudents() {
		return studentService.getAllStudents();
	}
	
}
