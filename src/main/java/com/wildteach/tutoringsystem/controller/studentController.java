package com.wildteach.tutoringsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wildteach.tutoringsystem.dto.updatePasswordDTO;
import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.service.studentService;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class studentController {

    @Autowired
    private studentService studentService;

    
    @PostMapping("/add")
    public String addStudent(@RequestBody studentEntity student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/all")
    public List<studentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getById/{id}")
    public studentEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<studentEntity> updateStudent(@PathVariable Long id, @RequestBody studentEntity studentDetails) {
        studentEntity updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Student not found");
        }
    }

    @PostMapping("/login")
	public ResponseEntity<String> loginStudent(@RequestBody studentEntity student) {
		boolean isAuthenticated = studentService.authenticateStudent(student.getEmail(), student.getPassword());
		if (isAuthenticated) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(401).body("Invalid email or password");
		}
	}
    @PutMapping("/updatePassword")
    public ResponseEntity<String> updateStudentPassword(
        @RequestBody updatePasswordDTO dto) {  // Use the DTO here
    
        // Extract studentId from the request (assuming it's part of the logged-in user or passed in the body)
        Long studentId = dto.getStudentId();  // Add this to your DTO if it's not there
    
        if (studentId == null) {
            return ResponseEntity.status(400).body("Student ID is missing");
        }
    
        boolean success = studentService.updateStudentPassword(
            studentId,  // Use the extracted student ID
            dto.getOldPassword(), 
            dto.getNewPassword());  // Use the DTO's fields
    
        if (success) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(400).body("Current password is incorrect");
        }
    }
    


}
