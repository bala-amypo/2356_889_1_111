package com.example.demo.model;

import com.example.demo.model.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "room_assignment")
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public Long getStudentAId() {
        return studentAId;
    }

    public Long getStudentBId() {
        return studentBId;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}