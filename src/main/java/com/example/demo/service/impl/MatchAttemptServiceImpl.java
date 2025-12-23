package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    @Override
    public MatchAttemptRecord computeMatch(Long initiatorStudentId, Long candidateStudentId) {
        MatchAttemptRecord record = new MatchAttemptRecord();
        record.setInitiatorStudentId(initiatorStudentId);
        record.setCandidateStudentId(candidateStudentId);
        return record;
    }

    @Override
    public List<MatchAttemptRecord> getMatchesForStudent(Long studentId) {
        return new ArrayList<>();
    }

    @Override
    public MatchAttemptRecord getMatchById(Long id) {
        return new MatchAttemptRecord();
    }
}