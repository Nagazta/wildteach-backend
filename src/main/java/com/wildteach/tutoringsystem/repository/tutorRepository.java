package com.wildteach.tutoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wildteach.tutoringsystem.entity.tutorEntity;

public interface tutorRepository extends JpaRepository<tutorEntity, Long> {
}
