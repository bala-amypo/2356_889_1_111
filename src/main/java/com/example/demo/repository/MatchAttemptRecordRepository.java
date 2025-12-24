package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MatchAttemptRecord;
import java.util.*;

public interface MatchAttemptRecordRepository
        extends JpaRepository<MatchAttemptRecord, Long> {

    List<MatchAttemptRecord>
    findByInitiatorStudentIdOrCandidateStudentId(Long a, Long b);
}
