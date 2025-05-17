package com.student.StudentManagement.service;

import com.student.StudentManagement.dao.StudentRepository;
import com.student.StudentManagement.dao.TeacherRepository;
import com.student.StudentManagement.dto.TeacherDto;
import com.student.StudentManagement.entity.Teacher;
import jakarta.persistence.EntityNotFoundException;
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

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
    }

    public Teacher createTeacher(@Valid TeacherDto teacher) {
        Teacher newTeacher = new Teacher();
        newTeacher.setTid(teacher.getTid());
        newTeacher.setName(teacher.getName());
        newTeacher.setDob(teacher.getDob());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setAddress(teacher.getAddress());
        return teacherRepository.save(newTeacher);
    }
}
