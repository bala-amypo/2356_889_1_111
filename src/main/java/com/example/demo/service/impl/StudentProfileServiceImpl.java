package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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
    public StudentProfile saveProfile(StudentProfile profile) {
        return repo.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public StudentProfile getProfileByStudentId(String studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repo.findAll();
    }

    @Override
    public StudentProfile deactivateProfile(Long id) {
        StudentProfile p = repo.findById(id).orElse(null);
        if (p != null) {
            p.setActive(false);
            return repo.save(p);
        }
        return null;
    }
}
