package com.student.student_microservice.service;

import org.springframework.stereotype.Service;

import com.student.student_microservice.dto.request.CreateUpdateStudentRequestDto;
import com.student.student_microservice.dto.response.GetClassroomResponseDto;
import com.student.student_microservice.dto.response.GetStudentFullDetailsResponseDto;
import com.student.student_microservice.model.Student;
import com.student.student_microservice.openfeign.ClassroomServiceClient;
import com.student.student_microservice.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomServiceClient classroomServiceClient;

    public StudentService(StudentRepository studentRepository, ClassroomServiceClient classroomServiceClient) {
        this.studentRepository = studentRepository;
        this.classroomServiceClient = classroomServiceClient;
    }

    public void createStudent(CreateUpdateStudentRequestDto requestDto) {
        Student student = new Student();
        Long classroomId = classroomServiceClient.getClassroomById(requestDto.getClassroomId()).getId();
        if (classroomId == null) {
            throw new RuntimeException("Classroom not found");
        }
        student.setClassroomId(classroomId);
        student.setName(requestDto.getName());
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public GetStudentFullDetailsResponseDto getStudentFullDetails(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        GetClassroomResponseDto classroom = classroomServiceClient.getClassroomById(student.getClassroomId());
        GetStudentFullDetailsResponseDto responseDto = new GetStudentFullDetailsResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setClassroomId(classroom.getId());
        responseDto.setClassroomCode(classroom.getCode());
        responseDto.setSchoolId(classroom.getSchoolId());
        return responseDto;
    }

    public void updateStudent(Long id, CreateUpdateStudentRequestDto requestDto) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        student.setName(requestDto.getName());
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
