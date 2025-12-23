package com.example.demo.service.impl;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdate(HabitProfileDto dto) {
        HabitProfile profile = repo
                .findByStudentId(dto.getStudentId())
                .orElse(new HabitProfile());

        profile.setStudentId(dto.getStudentId());
        profile.setSleepSchedule(dto.getSleepSchedule());
        profile.setCleanlinessLevel(dto.getCleanlinessLevel());
        profile.setNoiseTolerance(dto.getNoiseTolerance());
        profile.setSocialPreference(dto.getSocialPreference());

        return repo.save(profile);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }
}