package com.example.demo.model;

public class MatchAttemptRecord {

    private Long id;
    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;
    private AttemptStatus status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(Long initiatorStudentId) {
        this.initiatorStudentId = initiatorStudentId;
    }

    public Long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(Long candidateStudentId) {
        this.candidateStudentId = candidateStudentId;
    }

    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(Long resultScoreId) {
        this.resultScoreId = resultScoreId;
    }

    public AttemptStatus getStatus() { return status; }
    public void setStatus(AttemptStatus status) { this.status = status; }
}
