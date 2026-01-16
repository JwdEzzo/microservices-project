package com.student.student_microservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetClassroomResponseDto {

   private Long id;
   private String code;
   private Long schoolId;

}
