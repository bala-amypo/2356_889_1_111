package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RoomAssignmentRecord;

public interface RoomAssignmentRecordRepository
        extends JpaRepository<RoomAssignmentRecord, Long> {

    List<RoomAssignmentRecord> findByStudentAIdOrStudentBId(Long id1, Long id2);

}