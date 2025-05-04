package com.wildteach.tutoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildteach.tutoringsystem.entity.paymentEntity;

import org.springframework.data.jpa.repository.Query;

public interface paymentRepository extends JpaRepository<paymentEntity, Long> {
    @Query("SELECT SUM(p.amount) FROM paymentEntity p WHERE p.status = 'Completed'")
    Double getTotalCompletedPayments();
}
