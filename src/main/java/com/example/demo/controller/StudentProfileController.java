package com.example.demo.controller;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfileDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public StudentProfile update(
            @PathVariable Long id,
            @RequestBody StudentProfileDto dto) {
        return service.update(id, dto);
    }
}