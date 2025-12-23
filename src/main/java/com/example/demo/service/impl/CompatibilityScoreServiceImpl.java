package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository scoreRepo,
            HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {

        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("same student");
        }

        habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        double score = Math.abs(studentAId - studentBId) % 100;

        CompatibilityScoreRecord record =
                scoreRepo.findByStudentAIdAndStudentBId(studentAId, studentBId)
                        .orElse(new CompatibilityScoreRecord());

        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(score);
        record.setCompatibilityLevel(
                score >= 80 ? "EXCELLENT" :
                score >= 60 ? "HIGH" :
                score >= 40 ? "MEDIUM" : "LOW"
        );

        return scoreRepo.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}