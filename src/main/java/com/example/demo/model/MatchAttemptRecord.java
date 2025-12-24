package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private AttemptStatus status;

    private LocalDateTime attemptedAt;

    public MatchAttemptRecord() {}

    @PrePersist
    public void attemptTime() {
        this.attemptedAt = LocalDateTime.now();
    }

    // REQUIRED BY TESTS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AttemptStatus getStatus() { return status; }
    public void setStatus(AttemptStatus status) { this.status = status; }
}
