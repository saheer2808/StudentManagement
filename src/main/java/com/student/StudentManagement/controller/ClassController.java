package com.student.StudentManagement.controller;

import com.student.StudentManagement.dto.ClassDto;
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
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@Valid @RequestBody ClassDto cls) {
        ClassEntity createdClass = classService.createClass(cls);
        return new ResponseEntity<>(createdClass, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Long id) {
        ClassEntity classEntity = classService.getClassById(id);
        return new ResponseEntity<>(classEntity, HttpStatus.OK);
    }

}