package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;

public interface StudentProfileService {

    StudentProfile createProfile(StudentProfileDto dto);

    StudentProfile updateProfile(Long id, StudentProfileDto dto);

    Optional<StudentProfile> getProfileById(Long id);
}