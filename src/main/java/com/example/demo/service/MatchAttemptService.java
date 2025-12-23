package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord computeMatch(Long studentAId, Long studentBId);

    List<MatchAttemptRecord> getMatchesForStudent(Long studentId);

    MatchAttemptRecord getMatchById(Long id);
}