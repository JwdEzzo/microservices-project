package com.classroom.classroom_microservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.classroom.classroom_microservice.dto.response.GetStudentResponseDto;

@FeignClient(name = "student-microservice", path = "/api/students")
public interface StudentServiceClient {

   @GetMapping("/classroom/{classroomId}")
   public GetStudentResponseDto getStudentsByClassroomId(@PathVariable("classroomId") Long classroomId);

   @GetMapping("/{studentId}")
   public GetStudentResponseDto getStudentById(@PathVariable("studentId") Long studentId);

   @GetMapping("/name/{name}")
   public GetStudentResponseDto getStudentByName(@PathVariable("name") String name);

}
