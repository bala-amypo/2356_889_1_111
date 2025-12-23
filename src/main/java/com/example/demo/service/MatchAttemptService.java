package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;

import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record);

    List<MatchAttemptRecord> getAttemptsByStudent(Long studentId);

    MatchAttemptRecord getAttemptById(Long id);
}