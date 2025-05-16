package com.student.StudentManagement.dao;

import com.student.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find students by class name
//    List<Student> findByClassName(String className);
//
//    // Additional queries can be added here
//    List<Student> findByLastName(String lastName);
//
//    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}