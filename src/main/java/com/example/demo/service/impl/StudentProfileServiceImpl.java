package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile profile) {
        return repo.save(profile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        
        StudentProfile profile = repo.findById(id);
        if (profile == null) {
            throw new RuntimeException("Not found");
        }
        return profile;
    }

    @Override
    public StudentProfile findByStudentId(String studentId) {
        StudentProfile profile = repo.findByStudentId(studentId);
        if (profile == null) {
            throw new RuntimeException("Not found");
        }
        return profile;
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile profile = repo.findById(id);
        if (profile == null) {
            throw new RuntimeException("Not found");
        }
        profile.setActive(active);
        return repo.save(profile);
    }
}
