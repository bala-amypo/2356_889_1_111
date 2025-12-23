package com.example.demo.controller;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
@Tag(name = "Habit Profiles")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping
    public HabitProfile createOrUpdate(@RequestBody HabitProfileDto dto) {
        return service.createOrUpdate(dto);
    }

    @GetMapping("/student/{studentId}")
    public HabitProfile getForStudent(@PathVariable Long studentId) {
        return service.getForStudent(studentId);
    }
}