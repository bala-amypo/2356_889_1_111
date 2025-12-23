package com.example.demo.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public CompatibilityScoreRecord compute(Long a, Long b) {
        int score = (int) Math.round(Math.random() * 100);

        CompatibilityScoreRecord r = new CompatibilityScoreRecord();
        r.setStudentAId(a);
        r.setStudentBId(b);
        r.setScore(score);
        r.setCompatibilityLevel(score >= 70 ? "HIGH" : "LOW");
        r.setComputedAt(LocalDateTime.now());

        return repo.save(r);
    }
}