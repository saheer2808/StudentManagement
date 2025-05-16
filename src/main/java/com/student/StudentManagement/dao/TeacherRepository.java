package com.student.StudentManagement.dao;

import com.student.StudentManagement.entity.ClassEntity;
import com.student.StudentManagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}