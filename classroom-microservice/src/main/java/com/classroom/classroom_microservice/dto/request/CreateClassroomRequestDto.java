package com.classroom.classroom_microservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassroomRequestDto {

   @NotBlank(message = "Classroom code is required")
   private String code;
}
