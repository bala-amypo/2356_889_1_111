package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;

@Service
public class StudentProfileServiceImpl {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile getByStudentId(Long id) {
        return repo.findByStudentId(id).orElse(null);
    }
}