package com.student.student_microservice.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.student_microservice.dto.response.GetClassroomResponseDto;

@FeignClient(name = "classroom-microservice", path = "api/classrooms")
public interface ClassroomServiceClient {
   @GetMapping("/school/{schoolId}/classrooms")
   public List<GetClassroomResponseDto> getClassroomsBySchoolId(@PathVariable("schoolId") Long schoolId);

   @GetMapping("/code/{code}")
   public GetClassroomResponseDto getClassroomByCode(@PathVariable("code") String code);

   @GetMapping("/{classroomId}")
   public GetClassroomResponseDto getClassroomById(@PathVariable("classroomId") Long classroomId);

}
