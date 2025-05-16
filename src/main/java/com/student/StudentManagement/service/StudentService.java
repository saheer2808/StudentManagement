package com.student.StudentManagement.service;

import com.student.StudentManagement.dao.StudentRepository;
import com.student.StudentManagement.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // Get student by id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }
    
    // Get students by class
    public List<Student> getStudentsByClass(String className) {
        return new ArrayList<>();
//        return studentRepository.findByClassName(className);
    }
    
    // Update student
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        
//        student.setFirstName(studentDetails.getFirstName());
//        student.setLastName(studentDetails.getLastName());
//        student.setDateOfBirth(studentDetails.getDateOfBirth());
//        student.setEmail(studentDetails.getEmail());
//        student.setClassName(studentDetails.getClassName());
//        student.setAddress(studentDetails.getAddress());
//        student.setPhoneNumber(studentDetails.getPhoneNumber());
        
        return studentRepository.save(student);
    }
    
    // Delete student
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}