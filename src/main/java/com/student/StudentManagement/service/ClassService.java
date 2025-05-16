package com.student.StudentManagement.service;

import com.student.StudentManagement.dao.ClassRepository;
import com.student.StudentManagement.dao.StudentRepository;
import com.student.StudentManagement.entity.ClassEntity;
import com.student.StudentManagement.entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {


    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }


    public ClassEntity createClass(ClassEntity classe) {
        return classRepository.save(classe);
    }

}

