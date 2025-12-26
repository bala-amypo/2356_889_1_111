package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
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

    // POST /api/match-attempts
    @PostMapping
    public MatchAttemptRecord log(@RequestBody MatchAttemptRecord record) {
        return service.logMatchAttempt(record);
    }

    // PUT /api/match-attempts/{id}/status
    @PutMapping("/{id}/status")
    public MatchAttemptRecord updateStatus(@PathVariable Long id,
                                           @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // GET /api/match-attempts/student/{studentId}
    @GetMapping("/student/{studentId}")
    public List<MatchAttemptRecord> getForStudent(@PathVariable Long studentId) {
        return service.getForStudent(studentId);
    }

    // GET /api/match-attempts/{id}
    @GetMapping("/{id}")
    public MatchAttemptRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET /api/match-attempts
    @GetMapping
    public List<MatchAttemptRecord> getAll() {
        return service.getAll();
    }
}
