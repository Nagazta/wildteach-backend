package com.wildteach.tutoringsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wildteach.tutoringsystem.entity.tutorEntity;
import com.wildteach.tutoringsystem.service.tutorService;

@RestController
@RequestMapping("/tutor")
@CrossOrigin(origins = "*") 
public class tutorController {
    
    @Autowired
    private tutorService tutorService;

    @PostMapping("/add")
    public ResponseEntity<String> addTutor(@RequestBody tutorEntity tutor) {
        tutorService.saveTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body("New tutor profile added");
    }

    @GetMapping("/all")
    public List<tutorEntity> getAllTutors() {
        return tutorService.getAllTutors();
    }

    @GetMapping("/getById/{id}")
    public tutorEntity getTutorById(@PathVariable Long id) {
        return tutorService.getTutorById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<tutorEntity> updateTutor(@PathVariable Long id, @RequestBody tutorEntity tutorDetails) {
        tutorEntity updatedTutor = tutorService.updateTutor(id, tutorDetails);
        if (updatedTutor != null) {
            return ResponseEntity.ok(updatedTutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tutor profile deleted");
    }
}
