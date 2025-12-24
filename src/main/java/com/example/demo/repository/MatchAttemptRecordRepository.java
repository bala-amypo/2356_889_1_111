package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.MatchAttemptRecord;

public interface MatchAttemptRecordRepository
        extends JpaRepository<MatchAttemptRecord, Long> {

    // EXACT TEST SIGNATURE
    List<MatchAttemptRecord> findByInitiatorStudentIdOrCandidateStudentId(
            Long id1, Long id2
    );
}
