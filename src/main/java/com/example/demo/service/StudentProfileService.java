package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;

public interface StudentProfileService {

    StudentProfile create(StudentProfileDto dto);

    StudentProfile get(Long id);

    List<StudentProfile> getAll();

    StudentProfile update(Long id, StudentProfileDto dto);
}