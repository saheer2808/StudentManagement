package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.StudentDto;
import com.student.StudentManagement.entity.ClassEntity;
import com.student.StudentManagement.entity.Student;
import com.student.StudentManagement.entity.Teacher;
import com.student.StudentManagement.service.ClassService;
import com.student.StudentManagement.service.StudentService;
import com.student.StudentManagement.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    // Create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDto student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    
    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Get student by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    // Get students by class
    @GetMapping("/class/{classId}")
    public ResponseEntity<List<Student>> getStudentsByClass(@PathVariable Long classId) {
        List<Student> students = studentService.getStudentsByClassId(classId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
    
    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}