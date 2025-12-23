package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/students")
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
    public StudentProfile get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public StudentProfile update(@PathVariable Long id,
                                 @RequestBody StudentProfileDto dto) {
        return service.update(id, dto);
    }
}