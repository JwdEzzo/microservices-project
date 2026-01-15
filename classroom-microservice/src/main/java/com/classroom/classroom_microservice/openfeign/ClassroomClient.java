package com.classroom.classroom_microservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "classroom-microservice", path = "api/classrooms")
public interface ClassroomClient {
   @GetMapping("/school/{schoolId}")
   public String getClassroomsBySchoolId(Long schoolId);

   @GetMapping("/code/{code}")
   public String getClassroomByCode(String code);

   @GetMapping("/student/{studentId}")
   public String getClassroomsByStudentId(Long studentId);
}
