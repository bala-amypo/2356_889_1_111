package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/assign")
    public ResponseEntity<RoomAssignmentRecord> assign(
            @RequestBody RoomAssignmentRecord record
    ) {
        return ResponseEntity.ok(service.assignRoom(record));
    }
}
