package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public MatchAttemptRecord computeMatch(Long studentAId, Long studentBId) {
        MatchAttemptRecord record = new MatchAttemptRecord();
        record.setStudentId(studentAId);
        record.setAttemptCount(1);
        return repo.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getMatchesForStudent(Long studentId) {
        return repo.findAll()
                   .stream()
                   .filter(r -> r.getStudentId().equals(studentId))
                   .toList();
    }

    @Override
    public MatchAttemptRecord getMatchById(Long id) {
        return repo.findById(id).orElse(null);
    }
}