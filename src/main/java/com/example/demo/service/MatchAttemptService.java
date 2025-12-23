package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface MatchAttemptService {

    CompatibilityScoreRecord computeMatch(Long studentAId, Long studentBId);

    List<CompatibilityScoreRecord> getMatchesForStudent(Long studentId);

    CompatibilityScoreRecord getMatchById(Long id);
}