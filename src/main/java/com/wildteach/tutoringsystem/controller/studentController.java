package com.wildteach.tutoringsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.service.studentService;

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
	// Endpoint to get a student by ID
	@GetMapping("/getById/{id}")
	public studentEntity getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	
	// Endpoint to update a student by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<studentEntity> updateStudent(@PathVariable Long id, @RequestBody studentEntity studentDetails) {
		studentEntity updatedStudent = studentService.updateStudent(id, studentDetails);
		if (updatedStudent != null) {
			return ResponseEntity.ok(updatedStudent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	// Endpoint to delete a student by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		boolean deleted = studentService.deleteStudent(id);
		if (deleted) {
			return ResponseEntity.ok("Student deleted successfully");
		} else {
			return ResponseEntity.status(404).body("Student not found");
		}
	}
}
