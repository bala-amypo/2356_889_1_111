package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord computeMatch(Long initiatorStudentId, Long candidateStudentId);

    List<MatchAttemptRecord> getMatchesForStudent(Long studentId);

    MatchAttemptRecord getMatchById(Long id);
}