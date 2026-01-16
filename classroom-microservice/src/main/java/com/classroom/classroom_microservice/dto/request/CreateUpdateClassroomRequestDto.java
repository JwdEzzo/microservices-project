package com.classroom.classroom_microservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateClassroomRequestDto {

   @NotBlank(message = "Classroom code is required")
   private String code;

   @NotNull(message = "School ID cannot be null")
   @Min(value = 1, message = "School ID must be greater than 0")
   private Long schoolId;
}
