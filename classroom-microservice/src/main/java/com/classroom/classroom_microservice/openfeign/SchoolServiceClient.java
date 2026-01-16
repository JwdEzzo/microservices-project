package com.classroom.classroom_microservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.classroom.classroom_microservice.dto.response.GetSchoolResponseDto;

@FeignClient(name = "school-microservice", path = "/api/schools")
public interface SchoolServiceClient {

   @GetMapping("/{schoolId}")
   public GetSchoolResponseDto getSchoolById(@PathVariable("schoolId") Long schoolId);
}
