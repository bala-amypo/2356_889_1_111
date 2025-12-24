package com.example.demo.repository;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.Optional;

public interface CompatibilityScoreRecordRepository {
    Optional<CompatibilityScoreRecord> findById(Long id);
}
