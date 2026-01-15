package com.classroom.classroom_microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.classroom.classroom_microservice.dto.request.CreateClassroomRequestDto;
import com.classroom.classroom_microservice.model.Classroom;
import com.classroom.classroom_microservice.repository.ClassroomRepository;

@Service
public class ClassroomService {

   private final ClassroomRepository classroomRepository;

   public ClassroomService(ClassroomRepository classroomRepository) {
      this.classroomRepository = classroomRepository;
   }

   public void createClassroom(CreateClassroomRequestDto requestDto) {
      Classroom classroom = new Classroom();
      classroom.setCode(requestDto.getCode());
      classroomRepository.save(classroom);
   }

   public Classroom getClassroomById(Long id) {
      return classroomRepository.findById(id).orElse(null);
   }

   public List<Classroom> getAllClassrooms() {
      return classroomRepository.findAll();
   }

   public Optional<Classroom> getClassroomByCode(String code) {
      return classroomRepository.findByCode(code);
   }

   public void updateClassroom(Long id, String code) {
      Classroom classroom = classroomRepository.findById(id).orElse(null);
      if (classroom == null) {
         throw new RuntimeException("Classroom not found");
      }
      classroom.setCode(code);
      classroomRepository.save(classroom);
   }

   public void deleteClassroom(Long id) {
      if (!classroomRepository.existsById(id)) {
         throw new RuntimeException("Classroom not found");
      }
      classroomRepository.deleteById(id);
   }

}
