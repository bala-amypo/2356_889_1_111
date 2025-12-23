package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface MatchService {

    CompatibilityScoreRecord compute(Long studentAId, Long studentBId);

    List<CompatibilityScoreRecord> getMatchesFor(Long studentId);

    CompatibilityScoreRecord getById(Long id);
}