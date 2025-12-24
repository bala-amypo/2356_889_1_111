package com.example.demo.repository;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileRepository {

    StudentProfile save(StudentProfile profile);

    StudentProfile findById(Long id);

    StudentProfile findByStudentId(String studentId);

    List<StudentProfile> findAll();
}
