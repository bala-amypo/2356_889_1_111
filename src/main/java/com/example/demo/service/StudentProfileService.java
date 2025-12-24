package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public class StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileService(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile createStudent(StudentProfile profile) {
        if (repo.findByStudentId(profile.getStudentId()).isPresent()) {
            throw new IllegalArgumentException("studentId exists");
        }
        return repo.save(profile);
    }

    public StudentProfile getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("not found"));
    }

    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    public StudentProfile findByStudentId(String studentId) {
        return repo.findByStudentId(studentId).orElseThrow(() ->
                new ResourceNotFoundException("not found"));
    }

    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile sp = getStudentById(id);
        sp.setActive(active);
        return repo.save(sp);
    }
}
