package com.wildteach.tutoringsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wildteach.tutoringsystem.entity.studentEntity;
import com.wildteach.tutoringsystem.repository.studentRepository;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentRepository studentRepository;

    @Override
    public studentEntity saveStudent(studentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public List<studentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public studentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public studentEntity updateStudent(Long id, studentEntity studentDetails) {
        studentEntity student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setLast_name(studentDetails.getLast_name());
            student.setFirst_name(studentDetails.getFirst_name());
            student.setMiddle_name(studentDetails.getMiddle_name());
            student.setBirth_date(studentDetails.getBirth_date());
            student.setGender(studentDetails.getGender());
            student.setEmail(studentDetails.getEmail());
            student.setContact_number(studentDetails.getContact_number());
            student.setAddress(studentDetails.getAddress());
            student.setUsername(studentDetails.getUsername());
            student.setCourse(studentDetails.getCourse());
            student.setYear_level(studentDetails.getYear_level());
            student.setRole(studentDetails.getRole());
            student.setPassword(studentDetails.getPassword());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean authenticateStudent(String email, String password) {
		studentEntity student = studentRepository.findByEmail(email);
		return student != null && student.getPassword().equals(password) && student.getRole() == studentEntity.Role.Tutee;
	}
}
