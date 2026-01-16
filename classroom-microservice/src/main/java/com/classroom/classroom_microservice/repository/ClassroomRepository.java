package com.classroom.classroom_microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classroom.classroom_microservice.model.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

   Optional<Classroom> findByCode(String code);

   List<Classroom> findBySchoolId(Long schoolId);

}
