package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.MatchAttemptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-attempts")
@Tag(name = "Match Attempts")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping("/{studentAId}/{studentBId}")
    public CompatibilityScoreRecord compute(
            @PathVariable Long studentAId,
            @PathVariable Long studentBId) {
        return service.computeMatch(studentAId, studentBId);
    }

    @GetMapping("/student/{studentId}")
    public List<CompatibilityScoreRecord> getForStudent(
            @PathVariable Long studentId) {
        return service.getMatchesForStudent(studentId);
    }

    @GetMapping("/{id}")
    public CompatibilityScoreRecord getById(@PathVariable Long id) {
        return service.getMatchById(id);
    }
}