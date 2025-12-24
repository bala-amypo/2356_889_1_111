package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute/{a}/{b}")
    public CompatibilityScoreRecord compute(
            @PathVariable Long a,
            @PathVariable Long b) {
        return service.computeScore(a, b);
    }

    @GetMapping("/student/{id}")
    public List<CompatibilityScoreRecord> getByStudent(@PathVariable Long id) {
        return service.getScoresForStudent(id);
    }

    @GetMapping("/{id}")
    public CompatibilityScoreRecord get(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @GetMapping
    public List<CompatibilityScoreRecord> getAll() {
        return service.getAllScores();
    }
}
