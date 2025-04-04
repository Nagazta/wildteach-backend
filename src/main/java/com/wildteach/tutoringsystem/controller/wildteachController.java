package com.wildteach.tutoringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildteach.tutoringsystem.entity.wildteachEntity;
import com.wildteach.tutoringsystem.service.wildteachService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class wildteachController {
	@Autowired
	private wildteachService studentService;
	
	@PostMapping("/add")
	public String addStudent(@RequestBody wildteachEntity student) {
		studentService.saveStudent(student);
		return "New student is added";
	}
}
