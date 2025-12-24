package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;

public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    public ResponseEntity<CompatibilityScoreRecord> compute(Long a, Long b) {
        return ResponseEntity.ok(service.computeScore(a, b));
    }
}
