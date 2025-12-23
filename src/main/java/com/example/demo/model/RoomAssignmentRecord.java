package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "room_assignments")
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    // ✅ STRING (NOT ENUM)
    private String status;

    private LocalDateTime assignedAt;

    public Long getId() {
        return id;
    }

    public Long getStudentAId() {
        return studentAId;
    }

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public Long getStudentBId() {
        return studentBId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
}
