package com.classroom.classroom_microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.classroom.classroom_microservice.dto.request.CreateUpdateClassroomRequestDto;
import com.classroom.classroom_microservice.model.Classroom;
import com.classroom.classroom_microservice.openfeign.SchoolServiceClient;
import com.classroom.classroom_microservice.repository.ClassroomRepository;

@Service
public class ClassroomService {

   private final ClassroomRepository classroomRepository;
   private final SchoolServiceClient schoolServiceClient;

   public ClassroomService(ClassroomRepository classroomRepository, SchoolServiceClient schoolServiceClient) {
      this.classroomRepository = classroomRepository;
      this.schoolServiceClient = schoolServiceClient;
   }

   public void createClassroom(CreateUpdateClassroomRequestDto requestDto) {
      Classroom classroom = new Classroom();
      Long schoolId = schoolServiceClient.getSchoolById(requestDto.getSchoolId()).getId();
      if (schoolId == null) {
         throw new RuntimeException("School not found");
      }
      classroom.setCode(requestDto.getCode());
      classroom.setSchoolId(schoolId);
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

   public List<Classroom> getClassroomsBySchoolId(Long schoolId) {
      return classroomRepository.findBySchoolId(schoolId);
   }

   public void updateClassroom(Long id, CreateUpdateClassroomRequestDto requestDto) {
      Classroom classroom = classroomRepository.findById(id).orElse(null);
      if (classroom == null) {
         throw new RuntimeException("Classroom not found");
      }
      classroom.setCode(requestDto.getCode());
      classroom.setSchoolId(schoolServiceClient.getSchoolById(requestDto.getSchoolId()).getId());
      classroomRepository.save(classroom);
   }

   public void deleteClassroom(Long id) {
      if (!classroomRepository.existsById(id)) {
         throw new RuntimeException("Classroom not found");
      }
      classroomRepository.deleteById(id);
   }

}
