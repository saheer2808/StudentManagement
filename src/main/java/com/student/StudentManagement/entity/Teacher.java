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
@Table(name = "Teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must be at most 50 characters")
    @Column(name = "Fname")
    private String fname;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "Lname")
    private String lname;

    @Past(message = "Date of birth must be in the past")
    @Column(name = "Dob")
    private LocalDate dob;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address must be at most 255 characters")
    @Column(name = "Address")
    private String address;

//    @ManyToOne
//    @JoinColumn(name = "ClassId")
//    private ClassEntity classEntity;

}