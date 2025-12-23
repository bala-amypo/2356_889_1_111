package com.example.demo.service.impl;

import java.util.List;

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
    public StudentProfile create(StudentProfileDto dto) {
        StudentProfile s = new StudentProfile();
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setActive(true);
        return repository.save(s);
    }

    @Override
    public StudentProfile get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentProfile not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public StudentProfile update(Long id, StudentProfileDto dto) {
        StudentProfile s = get(id);
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        return repository.save(s);
    }
}