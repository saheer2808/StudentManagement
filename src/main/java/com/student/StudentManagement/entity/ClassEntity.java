package com.student.StudentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Class")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @NotBlank(message = "Class name is required")
    @Size(max = 5, message = "Class name must be at most 2 characters")
    @Column(name = "ClassName")
    private String className;

    @ManyToOne
    @JoinColumn(name = "TeacherId")
    private Teacher teacher;

}