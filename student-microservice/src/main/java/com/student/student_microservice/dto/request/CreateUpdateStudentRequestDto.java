package com.student.student_microservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateStudentRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Classroom ID cannot be null")
    @Min(value = 1, message = "Classroom ID must be greater than 0")
    private Long classroomId;

}
