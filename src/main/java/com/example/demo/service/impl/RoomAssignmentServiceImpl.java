package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoomAssignmentRecord assign(Long a, Long b) {
        RoomAssignmentRecord r = new RoomAssignmentRecord();
        r.setStudentAId(a);
        r.setStudentBId(b);
        r.setStatus("ASSIGNED");
        r.setAssignedAt(LocalDateTime.now());
        return repo.save(r);
    }

    @Override
    public List<RoomAssignmentRecord> getAll() {
        return repo.findAll();
    }
}