package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createProfile(StudentProfileDto dto) {
        StudentProfile profile = new StudentProfile();
        profile.setName(dto.getName());
        profile.setEmail(dto.getEmail());
        profile.setActive(true);
        return repository.save(profile);
    }

    @Override
    public StudentProfile updateProfile(Long id, StudentProfileDto dto) {
        StudentProfile profile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentProfile not found"));

        profile.setName(dto.getName());
        profile.setEmail(dto.getEmail());
        return repository.save(profile);
    }

    @Override
    public Optional<StudentProfile> getProfileById(Long id) {
        return repository.findById(id);
    }
}