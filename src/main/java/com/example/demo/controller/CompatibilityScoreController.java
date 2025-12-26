
package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compatibility")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @GetMapping("/score")
    public ResponseEntity<CompatibilityScoreRecord> compute(
            @RequestParam Long a,
            @RequestParam Long b
    ) {
        return ResponseEntity.ok(service.computeScore(a, b));
    }
}
