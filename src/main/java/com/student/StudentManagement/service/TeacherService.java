package com.student.StudentManagement.service;

import com.student.StudentManagement.dao.StudentRepository;
import com.student.StudentManagement.dao.TeacherRepository;
import com.student.StudentManagement.entity.Teacher;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(@Valid Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
