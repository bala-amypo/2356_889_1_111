package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    public RoomAssignmentRecord assign(Long a, Long b) {
        RoomAssignmentRecord r = new RoomAssignmentRecord();
        r.setStudentAId(a);
        r.setStudentBId(b);
        r.setStatus("ASSIGNED");
        return repo.save(r);
    }

    public List<RoomAssignmentRecord> get(Long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }
}