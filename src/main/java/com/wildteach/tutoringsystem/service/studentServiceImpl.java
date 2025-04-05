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

	public studentEntity saveStudent(studentEntity student) {
		return studentRepository.save(student);
	}

	public List<studentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	public studentEntity getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

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

	public boolean deleteStudent(Long id) {
		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
