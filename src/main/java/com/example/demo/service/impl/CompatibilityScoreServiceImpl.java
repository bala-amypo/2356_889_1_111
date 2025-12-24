package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public CompatibilityScoreRecord getScore(Long id) {
       
        CompatibilityScoreRecord record = repo.findById(id);
        if (record == null) {
            throw new RuntimeException("Not found");
        }
        return record;
    }
}
