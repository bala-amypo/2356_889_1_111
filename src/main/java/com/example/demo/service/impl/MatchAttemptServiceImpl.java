package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;
import java.util.List;

public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository repo,
            CompatibilityScoreRecordRepository scoreRepo
    ) {
        this.repo = repo;
        this.scoreRepo = scoreRepo;
    }

    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord r) {
        return repo.save(r);
    }

    public List<MatchAttemptRecord> getAttemptsByStudent(Long id) {
        return repo.findByInitiatorStudentIdOrCandidateStudentId(id, id);
    }

    public MatchAttemptRecord getAttemptById(Long id) {
        return repo.findById(id).orElse(null);
    }
}