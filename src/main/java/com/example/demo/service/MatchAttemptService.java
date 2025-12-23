package com.example.demo.service;

import java.util.List;
import com.example.demo.model.MatchAttemptRecord;

public interface MatchAttemptService {

    MatchAttemptRecord computeMatch(Long studentAId, Long studentBId);

    List<MatchAttemptRecord> getMatchesForStudent(Long studentId);

    MatchAttemptRecord getMatchById(Long id);
}   