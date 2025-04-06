package com.wildteach.tutoringsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.service.studentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class studentController {
	@Autowired
	private studentService studentService;
	
	// Endpoint to add a new student
	@PostMapping("/add")
	public String addStudent(@RequestBody studentEntity student) {
		studentService.saveStudent(student);
		return "New student is added";
	}
	// Endpoint to get all students
	@GetMapping("/All")
	public List<studentEntity> getAllStudents() {
		return studentService.getAllStudents();
	} 
	//Endpoint to get a student by ID
	@GetMapping("/getById/{id}")
	public studentEntity getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	


	
}
