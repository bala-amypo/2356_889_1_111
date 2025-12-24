package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.RoomAssignmentRecord;
import java.util.*;

public interface RoomAssignmentRecordRepository
        extends JpaRepository<RoomAssignmentRecord, Long> {

    List<RoomAssignmentRecord>
    findByStudentAIdOrStudentBId(Long a, Long b);
}
