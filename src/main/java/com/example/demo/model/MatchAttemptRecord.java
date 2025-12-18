package com.example.project.entity;

import java.time.LocalDateTime;

public class MatchAttemptRecord {
    @Id
    private Long id;
    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;
    public MatchAttemptRecord(Long id, Long initiatorStudentId, Long candidateStudentId, Long resultScoreId,
            String status, LocalDateTime attemptedAt) {
        this.id = id;
        this.initiatorStudentId = initiatorStudentId;
        this.candidateStudentId = candidateStudentId;
        this.resultScoreId = resultScoreId;
        this.status = status;
        this.attemptedAt = attemptedAt;
    }
    private String status;
    private LocalDateTime attemptedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getInitiatorStudentId() {
        return initiatorStudentId;
    }
    public void setInitiatorStudentId(Long initiatorStudentId) {
        this.initiatorStudentId = initiatorStudentId;
    }
    public Long getCandidateStudentId() {
        return candidateStudentId;
    }
    public void setCandidateStudentId(Long candidateStudentId) {
        this.candidateStudentId = candidateStudentId;
    }
    public Long getResultScoreId() {
        return resultScoreId;
    }
    public void setResultScoreId(Long resultScoreId) {
        this.resultScoreId = resultScoreId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getAttemptedAt() {
        return attemptedAt;
    }
    public void setAttemptedAt(LocalDateTime attemptedAt) {
        this.attemptedAt = attemptedAt;
    }
    
}