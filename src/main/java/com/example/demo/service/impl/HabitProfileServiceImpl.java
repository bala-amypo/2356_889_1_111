package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdate(HabitProfileDto dto) {
        HabitProfile profile = repository
                .findByStudentId(dto.getStudentId())
                .orElse(new HabitProfile());

        profile.setStudentId(dto.getStudentId());
        profile.setSleepSchedule(dto.getSleepSchedule());
        profile.setCleanlinessLevel(dto.getCleanlinessLevel());
        profile.setNoiseTolerance(dto.getNoiseTolerance());
        profile.setSocialPreference(dto.getSocialPreference());

        return repository.save(profile);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return repository.findByStudentId(studentId).orElse(null);
    }
}