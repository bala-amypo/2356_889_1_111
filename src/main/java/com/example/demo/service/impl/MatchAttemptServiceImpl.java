package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final StudentProfileRepository studentRepo;
    private final HabitProfileRepository habitRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchServiceImpl(
            StudentProfileRepository studentRepo,
            HabitProfileRepository habitRepo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.studentRepo = studentRepo;
        this.habitRepo = habitRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public CompatibilityScoreRecord compute(Long studentAId, Long studentBId) {

        studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = Math.abs(studentAId - studentBId) % 100;

        CompatibilityScoreRecord r =
                scoreRepo.findByStudentAIdAndStudentBId(studentAId, studentBId)
                        .orElse(new CompatibilityScoreRecord());

        r.setStudentAId(studentAId);
        r.setStudentBId(studentBId);
        r.setScore(score);
        r.setCompatibilityLevel(score > 70 ? "HIGH" : "MEDIUM");

        return scoreRepo.save(r);
    }

    @Override
    public List<CompatibilityScoreRecord> getMatchesFor(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public CompatibilityScoreRecord getById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
}