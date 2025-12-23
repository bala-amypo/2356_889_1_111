package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile create(StudentProfileDto dto) {
        StudentProfile s = new StudentProfile();
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setActive(true);
        return repo.save(s);
    }

    @Override
    public StudentProfile get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public StudentProfile update(Long id, StudentProfileDto dto) {
        StudentProfile s = repo.findById(id).orElse(null);
        if (s == null) {
            return null;
        }
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        return repo.save(s);
    }
}
