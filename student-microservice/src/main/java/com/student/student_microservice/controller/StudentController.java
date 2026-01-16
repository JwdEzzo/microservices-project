package com.student.student_microservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_microservice.dto.request.CreateUpdateStudentRequestDto;
import com.student.student_microservice.dto.response.GetStudentFullDetailsResponseDto;
import com.student.student_microservice.model.Student;
import com.student.student_microservice.service.StudentService;

@RestController
@SuppressWarnings("CallToPrintStackTrace")
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody CreateUpdateStudentRequestDto requestDto) {
        try {
            studentService.createStudent(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}/full-details")
    public ResponseEntity<GetStudentFullDetailsResponseDto> getStudentFullDetails(@PathVariable Long id) {
        try {
            GetStudentFullDetailsResponseDto student = studentService.getStudentFullDetails(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id,
            @RequestBody CreateUpdateStudentRequestDto requestDto) {
        try {
            studentService.updateStudent(id, requestDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
