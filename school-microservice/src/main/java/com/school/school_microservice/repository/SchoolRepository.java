package com.school.school_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.school_microservice.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    
}
