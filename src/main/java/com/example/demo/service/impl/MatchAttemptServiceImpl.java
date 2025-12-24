package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AttemptStatus;
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository repo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.repo = repo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        return repo.save(attempt);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return repo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord r = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        r.setStatus(AttemptStatus.valueOf(status));
        return repo.save(r);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }
}
