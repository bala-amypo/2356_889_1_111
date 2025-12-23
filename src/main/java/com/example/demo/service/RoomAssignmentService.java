package com.example.demo.service;

import java.util.List;
import com.example.demo.model.RoomAssignmentRecord;

public interface RoomAssignmentService {

    RoomAssignmentRecord assign(Long studentAId, Long studentBId);

    List<RoomAssignmentRecord> getAll();
}