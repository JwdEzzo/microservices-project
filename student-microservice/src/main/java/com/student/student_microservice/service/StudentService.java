package com.student.student_microservice.service;

import org.springframework.stereotype.Service;

import com.student.dto.request.CreateStudentRequestDto;
import com.student.student_microservice.model.Student;
import com.student.student_microservice.repository.StudentRepository;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(CreateStudentRequestDto createStudentRequestDto) {
        Student student = new Student();
        student.setName(createStudentRequestDto.getName());
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void updateStudent(Long id, String name) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        student.setName(name);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


}
