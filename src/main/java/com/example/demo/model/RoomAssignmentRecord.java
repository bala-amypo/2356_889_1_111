package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private Long studentAId;
    private Long studentBId;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    private LocalDateTime assignedAt;

    public RoomAssignmentRecord() {}

    @PrePersist
    public void assignTime() {
        this.assignedAt = LocalDateTime.now();
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }
}
