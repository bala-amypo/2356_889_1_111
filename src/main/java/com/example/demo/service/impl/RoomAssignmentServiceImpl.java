package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.Status;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository roomRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(Long a, Long b) {
        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentAId(a);
        record.setStudentBId(b);
        record.setStatus(Status.ACTIVE);
        return roomRepo.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsForStudent(Long studentId) {
        return roomRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }
}