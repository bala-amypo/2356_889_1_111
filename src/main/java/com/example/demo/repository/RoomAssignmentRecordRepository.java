package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.RoomAssignmentRecord;

public interface RoomAssignmentRecordRepository
        extends JpaRepository<RoomAssignmentRecord, Long> {

    // EXACT TEST SIGNATURE
    List<RoomAssignmentRecord> findByStudentAIdOrStudentBId(Long id1, Long id2);
}
