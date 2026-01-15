package com.classroom.classroom_microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.classroom_microservice.dto.request.CreateClassroomRequestDto;
import com.classroom.classroom_microservice.model.Classroom;
import com.classroom.classroom_microservice.service.ClassroomService;

import jakarta.validation.Valid;

@RestController
@SuppressWarnings("CallToPrintStackTrace")
@RequestMapping("/api/classrooms")
public class ClassroomController {

   private final ClassroomService classroomService;

   public ClassroomController(ClassroomService classroomService) {
      this.classroomService = classroomService;
   }

   @PostMapping
   public ResponseEntity<Void> createClassroom(@Valid @RequestBody CreateClassroomRequestDto requestDto) {
      try {
         classroomService.createClassroom(requestDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(null);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   @GetMapping()
   public ResponseEntity<List<Classroom>> getAllClassrooms() {
      try {
         List<Classroom> classrooms = classroomService.getAllClassrooms();
         return ResponseEntity.status(HttpStatus.OK).body(classrooms);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
   }

   @GetMapping("/{id}")
   public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
      try {
         Classroom classroom = classroomService.getClassroomById(id);
         return ResponseEntity.status(HttpStatus.OK).body(classroom);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
   }

   @GetMapping("/code/{code}")
   public ResponseEntity<Optional<Classroom>> getClassroomByCode(@PathVariable String code) {
      try {
         Optional<Classroom> classroom = classroomService.getClassroomByCode(code);
         return ResponseEntity.status(HttpStatus.OK).body(classroom);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
   }

}
