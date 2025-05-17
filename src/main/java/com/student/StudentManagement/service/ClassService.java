package com.student.StudentManagement.service;

import com.student.StudentManagement.dao.ClassRepository;
import com.student.StudentManagement.dao.StudentRepository;
import com.student.StudentManagement.dto.ClassDto;
import com.student.StudentManagement.entity.ClassEntity;
import com.student.StudentManagement.entity.Student;
import com.student.StudentManagement.entity.Teacher;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private TeacherService teacherService;

    public ClassEntity getClassById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Class not found with id: " + id));
    }

    public Boolean isClassExists(Long id) {
        return classRepository.existsById(id);
    }

    public ClassEntity createClass(ClassDto cls) {
        ClassEntity classEntity = new ClassEntity();

        classEntity.setClassId(cls.getClassId());
        classEntity.setClassName(cls.getClassName());

        Teacher tch = teacherService.getTeacherById(cls.getTeacher());
        classEntity.setTeacher(tch);

        return classRepository.save(classEntity);
    }

}

