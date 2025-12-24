package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attempts")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public MatchAttemptRecord create(
            @RequestParam Long initiatorId,
            @RequestParam Long candidateId) {
        return service.createAttempt(initiatorId, candidateId);
    }
}
