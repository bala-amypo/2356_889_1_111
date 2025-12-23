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

        double rawScore = Math.random() * 100;

        // ✅ SAFE CONVERSION
        int score = (int) Math.round(rawScore);

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(a);
        record.setStudentBId(b);
        record.setScore(score);

        // ✅ STRING VALUE
        record.setCompatibilityLevel(score >= 70 ? "HIGH" : "LOW");
        record.setComputedAt(LocalDateTime.now());

        return repo.save(record);
    }
}