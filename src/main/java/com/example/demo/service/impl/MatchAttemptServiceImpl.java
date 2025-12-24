package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.model.AttemptStatus;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository matchRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

   
    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository matchRepo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.matchRepo = matchRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord createAttempt(Long initiatorId, Long candidateId) {
        MatchAttemptRecord record = new MatchAttemptRecord();
        record.setInitiatorStudentId(initiatorId);
        record.setCandidateStudentId(candidateId);
        record.setStatus(AttemptStatus.SUCCESS);
        return matchRepo.save(record);
    }
}
