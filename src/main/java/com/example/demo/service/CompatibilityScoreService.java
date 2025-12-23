package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;

public interface CompatibilityScoreService {

    CompatibilityScoreRecord compute(Long studentAId, Long studentBId);
}