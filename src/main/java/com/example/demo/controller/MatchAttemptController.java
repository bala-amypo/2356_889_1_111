package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;

@RestController
@RequestMapping("/matches")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public MatchAttemptRecord compute(@RequestParam Long a, @RequestParam Long b) {
        return service.computeMatch(a, b);
    }

    @GetMapping("/student/{id}")
    public List<MatchAttemptRecord> getForStudent(@PathVariable Long id) {
        return service.getMatchesForStudent(id);
    }

    @GetMapping("/{id}")
    public MatchAttemptRecord get(@PathVariable Long id) {
        return service.getMatchById(id);
    }
}