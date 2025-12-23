package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;
    private final StudentProfileRepository studentRepo;

    public HabitProfileServiceImpl(
            HabitProfileRepository habitRepo,
            StudentProfileRepository studentRepo) {
        this.habitRepo = habitRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public HabitProfile createOrUpdate(HabitProfileDto dto) {

        studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        if (dto.getStudyHoursPerDay() != null && dto.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours invalid");
        }

        HabitProfile h = habitRepo.findByStudentId(dto.getStudentId())
                .orElse(new HabitProfile());

        h.setStudentId(dto.getStudentId());
        h.setSleepSchedule(dto.getSleepSchedule());
        h.setStudyHoursPerDay(dto.getStudyHoursPerDay());
        h.setCleanlinessLevel(dto.getCleanlinessLevel());
        h.setNoiseTolerance(dto.getNoiseTolerance());
        h.setSocialPreference(dto.getSocialPreference());

        return habitRepo.save(h);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}