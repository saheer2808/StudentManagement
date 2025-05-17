package com.student.StudentManagement.service;

import com.student.StudentManagement.dao.StudentRepository;
import com.student.StudentManagement.dto.StudentDto;
import com.student.StudentManagement.entity.ClassEntity;
import com.student.StudentManagement.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassService classService;

    // Create a new student
    public Student createStudent(StudentDto student) {

        Student std = new Student();

        std.setRollNo(student.getRollNo());
        std.setName(student.getName());
        std.setDob(student.getDob());
        std.setAddress(student.getAddress());
        std.setEmail(student.getEmail());
        std.setPhoneNumber(student.getPhoneNumber());

        var classExists = classService.isClassExists(student.getClassId());
        if (!classExists) {
            throw new EntityNotFoundException("Class not found with id: " + student.getClassId());
        }
        std.setClassId(student.getClassId());

        return studentRepository.save(std);
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
    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepository.findByClassId(classId);
    }
    
    // Update student
    public Student updateStudent(Long id, Student studentDetails) {

        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setDob(studentDetails.getDob());
        student.setEmail(studentDetails.getEmail());
        student.setClassId(studentDetails.getClassId());
        student.setAddress(studentDetails.getAddress());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        
        return studentRepository.save(student);
    }
    
    // Delete student
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}