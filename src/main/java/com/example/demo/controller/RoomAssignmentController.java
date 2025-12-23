package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;

@RestController
@RequestMapping("/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public RoomAssignmentRecord assign(
            @RequestParam Long a,
            @RequestParam Long b) {
        return service.assign(a, b);
    }

    @GetMapping
    public List<RoomAssignmentRecord> getAll() {
        return service.getAll();
    }
}