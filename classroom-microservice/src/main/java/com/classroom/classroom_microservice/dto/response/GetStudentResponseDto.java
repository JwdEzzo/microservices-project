package com.classroom.classroom_microservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentResponseDto {

   private Long id;
   private String name;
   private Long classroomId;

}
