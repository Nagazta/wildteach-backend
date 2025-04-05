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

import com.wildteach.tutoringsystem.entity.wildteachEntity;
import com.wildteach.tutoringsystem.service.wildteachService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
	//Endpoint to get a student by ID
	@GetMapping("/getById/{id}")
	public wildteachEntity getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	// Endpoint to update a student by ID
	
	@PutMapping("/update/{id}")
	public ResponseEntity<wildteachEntity> updateStudent(@PathVariable Long id, @RequestBody wildteachEntity studentDetails) {
		wildteachEntity updatedStudent = studentService.updateStudent(id, studentDetails);
		if (updatedStudent != null) {
			return ResponseEntity.ok(updatedStudent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
}
