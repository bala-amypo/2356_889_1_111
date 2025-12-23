package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_attempts")
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    private int score;

    private LocalDateTime attemptedAt;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getAttemptedAt() {
        return attemptedAt;
    }

    public void setAttemptedAt(LocalDateTime attemptedAt) {
        this.attemptedAt = attemptedAt;
    }
}