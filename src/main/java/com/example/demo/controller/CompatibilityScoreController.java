package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute")
    public ResponseEntity<CompatibilityScoreRecord> computeScore(
            @RequestParam Long studentAId,
            @RequestParam Long studentBId
    ) {
        return ResponseEntity.ok(service.computeScore(studentAId, studentBId));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getScoresForStudent(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getScoresForStudent(id));
    }
}