package com.wildteach.tutoringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildteach.tutoringsystem.entity.wildteachEntity;

@Repository
public interface wildteachRepository extends JpaRepository<wildteachEntity, Integer>{

}
