package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdate(HabitProfileDto dto) {
        HabitProfile h = repo.findByStudentId(dto.getStudentId())
                .orElse(new HabitProfile());

        h.setStudentId(dto.getStudentId());
        h.setSleepSchedule(dto.getSleepSchedule());
        h.setCleanlinessLevel(dto.getCleanlinessLevel());
        h.setNoiseTolerance(dto.getNoiseTolerance());
        h.setSocialPreference(dto.getSocialPreference());

        return repo.save(h);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }
}