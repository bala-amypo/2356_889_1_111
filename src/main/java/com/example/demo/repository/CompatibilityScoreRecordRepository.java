package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.CompatibilityScoreRecord;

public interface CompatibilityScoreRecordRepository
        extends JpaRepository<CompatibilityScoreRecord, Long> {

    Optional<CompatibilityScoreRecord>
        findByStudentAIdAndStudentBId(Long a, Long b);
}