package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final StudentProfileRepository studentRepo;
    private final HabitProfileRepository habitRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            StudentProfileRepository studentRepo,
            HabitProfileRepository habitRepo,
            CompatibilityScoreRecordRepository scoreRepo) {
        this.studentRepo = studentRepo;
        this.habitRepo = habitRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public CompatibilityScoreRecord computeMatch(Long studentAId, Long studentBId) {

        studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = Math.abs(studentAId - studentBId) % 100;

        CompatibilityScoreRecord record =
                scoreRepo.findByStudentAIdAndStudentBId(studentAId, studentBId)
                        .orElse(new CompatibilityScoreRecord());

        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(score);
        record.setCompatibilityLevel(score >= 70 ? "HIGH" : "MEDIUM");

        return scoreRepo.save(record);
    }

    @Override
    public List<CompatibilityScoreRecord> getMatchesForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public CompatibilityScoreRecord getMatchById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
}