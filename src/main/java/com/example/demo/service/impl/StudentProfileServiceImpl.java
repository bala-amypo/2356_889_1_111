package com.example.demo.service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile create(StudentProfileDto dto) {

        if (dto.getYearLevel() != null && dto.getYearLevel() <= 0) {
            throw new IllegalArgumentException("year must be positive");
        }

        repository.findByStudentId(dto.getStudentId())
                .ifPresent(s -> {
                    throw new IllegalArgumentException("studentId already exists");
                });

        StudentProfile s = new StudentProfile();
        s.setStudentId(dto.getStudentId());
        s.setFullName(dto.getFullName());
        s.setEmail(dto.getEmail());
        s.setDepartment(dto.getDepartment());
        s.setYearLevel(dto.getYearLevel());
        s.setActive(dto.getActive() == null ? true : dto.getActive());

        return repository.save(s);
    }

    @Override
    public StudentProfile update(Long id, StudentProfileDto dto) {
        StudentProfile s = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        s.setFullName(dto.getFullName());
        s.setDepartment(dto.getDepartment());
        s.setYearLevel(dto.getYearLevel());
        s.setActive(dto.getActive());

        return repository.save(s);
    }

    @Override
    public StudentProfile get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }
}