package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CompatibilityScoreService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public CompatibilityScoreRecord computeScore(Long a, Long b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException("same student");
        }

        HabitProfile h1 = habitRepo.findByStudentId(a)
                .orElseThrow(() -> new ResourceNotFoundException("habit not found"));
        HabitProfile h2 = habitRepo.findByStudentId(b)
                .orElseThrow(() -> new ResourceNotFoundException("habit not found"));

        double score = 50.0;
        score += Math.abs(h1.getStudyHoursPerDay() - h2.getStudyHoursPerDay()) <= 1 ? 20 : 0;

        CompatibilityScoreRecord rec =
                scoreRepo.findByStudentAIdAndStudentBId(a, b)
                        .orElse(new CompatibilityScoreRecord());

        rec.setStudentAId(a);
        rec.setStudentBId(b);
        rec.setScore(score);
        rec.setComputedAt(LocalDateTime.now());

        if (score >= 90) rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT);
        else if (score >= 70) rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.GOOD);
        else if (score >= 50) rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.AVERAGE);
        else rec.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.POOR);

        return scoreRepo.save(rec);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("score not found"));
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
