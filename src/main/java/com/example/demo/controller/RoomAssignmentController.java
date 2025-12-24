package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public RoomAssignmentRecord assign(
            @RequestParam Long studentAId,
            @RequestParam Long studentBId) {
        return service.assign(studentAId, studentBId);
    }
}
