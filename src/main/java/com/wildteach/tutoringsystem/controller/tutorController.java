package com.wildteach.tutoringsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.entity.tutorEntity;
import com.wildteach.tutoringsystem.service.tutorService;


@RestController
@RequestMapping("/tutor")
@CrossOrigin(origins = "*") 
public class tutorController {
    
    @Autowired
    private tutorService tutorService;


    // Endpoint to add a new tutor
    @PostMapping("/add")
    public ResponseEntity<String> addTutor(@RequestBody tutorEntity tutor) {
        tutorService.saveTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body("New tutor profile added");
    }
    // Endpoint to get all tutors
    @GetMapping("/all")
    public List<tutorEntity> getAllTutors() {
        return tutorService.getAllTutors();
    }
   // Endpoint to get a tutor by ID
    @GetMapping("/getById/{id}")
    public tutorEntity getTutorById(@PathVariable Long id) {
        return tutorService.getTutorById(id);
    }
    // Endpoint to update a tutor by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<tutorEntity> updateTutor(@PathVariable Long id, @RequestBody tutorEntity tutorDetails) {
        tutorEntity updatedTutor = tutorService.updateTutor(id, tutorDetails);
        if (updatedTutor != null) {
            return ResponseEntity.ok(updatedTutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Endpoint to delete a tutor by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tutor profile deleted");
    }
     //Endpoint to login a tutor
     @PostMapping("/login")
     public ResponseEntity<String> loginTutor(@RequestBody studentEntity student) {
         boolean isAuthenticated = tutorService.authenticateTutor(student.getEmail(), student.getPassword());
         if (isAuthenticated) {
             return ResponseEntity.ok("Login successful");
         } else {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
         }
     }
     


}
