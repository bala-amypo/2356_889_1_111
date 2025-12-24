package com.example.demo.repository;

import com.example.demo.model.CompatibilityScoreRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface CompatibilityScoreRecordRepository {

    CompatibilityScoreRecord findById(Long id);
}
