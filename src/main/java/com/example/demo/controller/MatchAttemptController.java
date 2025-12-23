package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public MatchAttemptRecord log(@RequestBody MatchAttemptRecord record) {
        return service.logMatchAttempt(record);
    }

    @GetMapping("/student/{studentId}")
    public List<MatchAttemptRecord> getByStudent(@PathVariable Long studentId) {
        return service.getAttemptsByStudent(studentId);
    }

    @GetMapping("/{id}")
    public MatchAttemptRecord getById(@PathVariable Long id) {
        return service.getAttemptById(id);
    }
}