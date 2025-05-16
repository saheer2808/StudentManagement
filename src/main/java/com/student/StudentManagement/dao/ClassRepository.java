package com.student.StudentManagement.dao;

import com.student.StudentManagement.entity.ClassEntity;
import com.student.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

}