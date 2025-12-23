package com.example.demo.model;

import com.example.demo.model.enums.CompatibilityLevel;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compatibility_score")
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private int score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;

    public Long getId() {
        return id;
    }

    public Long getStudentAId() {
        return studentAId;
    }

    public Long getStudentBId() {
        return studentBId;
    }

    public int getScore() {
        return score;
    }

    public CompatibilityLevel getCompatibilityLevel() {
        return compatibilityLevel;
    }

    public LocalDateTime getComputedAt() {
        return computedAt;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    public void setComputedAt(LocalDateTime computedAt) {
        this.computedAt = computedAt;
    }
}