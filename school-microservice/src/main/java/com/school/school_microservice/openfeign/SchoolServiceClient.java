package com.school.school_microservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "school-microservice", path = "api/schools")
public interface SchoolServiceClient {

   @GetMapping("/school/{schoolId}")
   public String getSchoolById(@PathVariable("schoolId") Long schoolId);

}
