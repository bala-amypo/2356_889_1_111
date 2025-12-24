package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.AssignmentStatus;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    @Override
    public RoomAssignmentRecord assign(Long studentAId, Long studentBId) {
        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setRoomNumber("R-101");
        record.setStatus(AssignmentStatus.ASSIGNED);
        return record;
    }
}
