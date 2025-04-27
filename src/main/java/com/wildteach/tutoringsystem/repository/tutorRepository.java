package com.wildteach.tutoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wildteach.tutoringsystem.entity.tutorEntity;

public interface tutorRepository extends JpaRepository<tutorEntity, Long> {
    // New method to count tutors with 'Approved' status
    long countByApprovalStatus(tutorEntity.ApprovalStatus approvalStatus);
}
