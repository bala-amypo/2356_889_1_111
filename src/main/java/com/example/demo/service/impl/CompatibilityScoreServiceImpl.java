package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.CompatibilityLevel;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final HabitProfileRepository habitRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public CompatibilityScoreServiceImpl(
            HabitProfileRepository habitRepo,
            CompatibilityScoreRecordRepository scoreRepo
    ) {
        this.habitRepo = habitRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long a, Long b) {

        HabitProfile p1 = habitRepo.findByStudentId(a).orElse(null);
        HabitProfile p2 = habitRepo.findByStudentId(b).orElse(null);

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(a);
        record.setStudentBId(b);
        record.setCompatibilityLevel(CompatibilityLevel.MEDIUM);
        record.setComputedAt(LocalDateTime.now());

        return scoreRepo.save(record);
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }
}