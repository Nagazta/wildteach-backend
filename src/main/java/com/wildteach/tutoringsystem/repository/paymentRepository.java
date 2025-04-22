package com.wildteach.tutoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildteach.tutoringsystem.entity.paymentEntity;

public interface paymentRepository extends JpaRepository<paymentEntity, Long> {
    
} 
