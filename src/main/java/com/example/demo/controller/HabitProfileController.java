package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping
    public HabitProfile createOrUpdate(@RequestBody HabitProfileDto dto) {
        return service.createOrUpdate(dto);
    }

    @GetMapping("/{studentId}")
    public HabitProfile get(@PathVariable Long studentId) {
        return service.getForStudent(studentId);
    }
}