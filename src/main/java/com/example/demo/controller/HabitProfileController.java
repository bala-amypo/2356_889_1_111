package com.example.demo.controller;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HabitProfile> createOrUpdate(
            @RequestBody HabitProfileDto dto
    ) {
        return ResponseEntity.ok(service.createOrUpdate(dto));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<HabitProfile> getForStudent(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getForStudent(id));
    }
}