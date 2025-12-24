package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityLevel;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
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
    public CompatibilityScoreRecord computeScore(Long a, Long b) {

        if (a.equals(b)) {
            throw new IllegalArgumentException("same student");
        }

        HabitProfile h1 = habitRepo.findByStudentId(a)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        HabitProfile h2 = habitRepo.findByStudentId(b)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        double score = 100 - Math.abs(
                h1.getStudyHoursPerDay() - h2.getStudyHoursPerDay()) * 5;
        score = Math.max(0, Math.min(100, score));

        CompatibilityScoreRecord r = new CompatibilityScoreRecord();
        r.setStudentAId(a);
        r.setStudentBId(b);
        r.setScore(score);

        
        r.setCompatibilityLevel(
                score >= 80 ? CompatibilityLevel.EXCELLENT :
                score >= 60 ? CompatibilityLevel.HIGH :
                score >= 40 ? CompatibilityLevel.MEDIUM :
                              CompatibilityLevel.LOW
        );

        r.setDetailsJson("{}");
        return scoreRepo.save(r);
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
