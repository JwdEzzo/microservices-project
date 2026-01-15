package com.student.student_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student_microservice.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
