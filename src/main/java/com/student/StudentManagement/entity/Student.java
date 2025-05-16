package com.student.StudentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Roll_no")
    private Integer rollNo;

    @Column(name = "Fname")
    private String fname;

    @Column(name = "Lname")
    private String lname;

    @Column(name = "Dob")
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @Column(name = "Email")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be valid")
    private String email;

    @Column(name = "Address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ClassId")
    private ClassEntity classEntity;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    private String phoneNumber;
}
