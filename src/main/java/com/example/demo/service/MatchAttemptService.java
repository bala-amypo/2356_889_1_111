package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;

public interface MatchAttemptService {
    MatchAttemptRecord createAttempt(Long initiatorId, Long candidateId);
}
