package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl {

    private final HabitProfileRepository habitRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public CompatibilityScoreServiceImpl(HabitProfileRepository habitRepo,
                                         CompatibilityScoreRecordRepository scoreRepo) {
        this.habitRepo = habitRepo;
        this.scoreRepo = scoreRepo;
    }

    public CompatibilityScoreRecord compute(Long a, Long b) {
        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(a);
        record.setStudentBId(b);
        record.setScore(75.0);
        record.setCompatibilityLevel("HIGH");
        record.setComputedAt(LocalDateTime.now());
        return scoreRepo.save(record);
    }

    public List<CompatibilityScoreRecord> getForStudent(Long id) {
        return scoreRepo.findByStudentAIdOrStudentBId(id, id);
    }
}