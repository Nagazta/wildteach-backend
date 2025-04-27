package com.wildteach.tutoringsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.entity.tutorEntity;
import com.wildteach.tutoringsystem.repository.studentRepository;
import com.wildteach.tutoringsystem.repository.tutorRepository;

@Service
public class tutorServiceImpl implements tutorService {

    @Autowired
    private tutorRepository tutorRepository;
    @Autowired
    private studentRepository studentRepository;

    @Override
    public tutorEntity saveTutor(tutorEntity tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public List<tutorEntity> getAllTutors() {
        return tutorRepository.findAll();
    }

    @Override
    public tutorEntity getTutorById(Long id) {
        return tutorRepository.findById(id).orElse(null);
    }

    @Override
    public tutorEntity updateTutor(Long id, tutorEntity tutorDetails) {
        tutorEntity tutor = tutorRepository.findById(id).orElse(null);
        if (tutor != null) {
            tutor.setSubjects_offered(tutorDetails.getSubjects_offered());
            tutor.setRate_per_hour(tutorDetails.getRate_per_hour());
            tutor.setAvailability(tutorDetails.getAvailability());
            tutor.setApprovalStatus(tutorDetails.getApprovalStatus());
            return tutorRepository.save(tutor);
        }
        return null;
    }

    @Override
    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }

    @Override
    public boolean authenticateTutor(String email, String password) {
        studentEntity student = studentRepository.findByEmail(email);
        return student != null && student.getPassword().equals(password)
                && student.getRole() == studentEntity.Role.Tutor;
    }

    @Override
    public int countActiveTutors() {
        // Count tutors who are 'Approved'
        return (int) tutorRepository.countByApprovalStatus(tutorEntity.ApprovalStatus.Approved);
    }

}
