package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.CompatibilityScoreRecord;

public interface CompatibilityScoreRecordRepository
        extends JpaRepository<CompatibilityScoreRecord, Long> {

    // EXACT NAMES REQUIRED BY TESTS
    CompatibilityScoreRecord findByStudentAIdAndStudentBId(Long id1, Long id2);

    List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(Long id1, Long id2);
}
