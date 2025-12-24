package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CompatibilityScoreRecord get(@PathVariable Long id) {
        return service.getScore(id);
    }
}
