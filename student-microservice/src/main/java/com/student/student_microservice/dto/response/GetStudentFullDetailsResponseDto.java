package com.student.student_microservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentFullDetailsResponseDto {

   private Long id;
   private String name;
   private Long classroomId;
   private String classroomCode;
   private Long schoolId;
}
