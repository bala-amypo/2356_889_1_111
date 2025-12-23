package com.example.demo.service.impl;

import java.time.LocalDateTime;
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
    public MatchAttemptRecord computeMatch(Long a, Long b) {
        MatchAttemptRecord r = new MatchAttemptRecord();
        r.setStudentAId(a);
        r.setStudentBId(b);
        r.setScore((int) (Math.random() * 100));
        r.setAttemptedAt(LocalDateTime.now());
        return repo.save(r);
    }

    @Override
    public List<MatchAttemptRecord> getMatchesForStudent(Long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }

    @Override
    public MatchAttemptRecord getMatchById(Long id) {
        return repo.findById(id).orElse(null);
    }
}