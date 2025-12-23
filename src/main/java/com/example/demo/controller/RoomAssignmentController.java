package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/assign")
    public ResponseEntity<RoomAssignmentRecord> assignRoom(
            @RequestParam Long studentAId,
            @RequestParam Long studentBId
    ) {
        return ResponseEntity.ok(service.assignRoom(studentAId, studentBId));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<RoomAssignmentRecord>> getAssignmentsForStudent(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getAssignmentsForStudent(id));
    }
}