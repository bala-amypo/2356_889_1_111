package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping("/compute")
    public ResponseEntity<MatchAttemptRecord> computeMatch(
            @RequestParam Long initiatorStudentId,
            @RequestParam Long candidateStudentId
    ) {
        return ResponseEntity.ok(
                service.computeMatch(initiatorStudentId, candidateStudentId)
        );
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<MatchAttemptRecord>> getMatchesForStudent(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getMatchesForStudent(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchAttemptRecord> getMatchById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getMatchById(id));
    }
}