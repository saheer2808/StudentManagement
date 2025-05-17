package com.student.StudentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private Integer rollNo;
    private String name;
    private LocalDate dob;
    private String email;
    private String address;
    private Long classId;
    private String phoneNumber;
}
