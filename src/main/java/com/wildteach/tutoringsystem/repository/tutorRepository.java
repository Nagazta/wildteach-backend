package com.wildteach.tutoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.wildteach.tutoringsystem.entity.tutorEntity;

public interface tutorRepository extends JpaRepository<tutorEntity, Long> {

    @Query("SELECT t FROM tutorEntity t WHERE t.student.student_id = :studentId")
    tutorEntity findByStudentId(@Param("studentId") Long studentId);
}
