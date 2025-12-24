package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() < 0) {
            throw new RuntimeException("Invalid study hours");
        }
        return repo.save(habit);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        HabitProfile habit = repo.findByStudentId(studentId);
        if (habit == null) {
            throw new RuntimeException("Not found");
        }
        return habit;
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        HabitProfile habit = repo.findById(id);
        if (habit == null) {
            throw new RuntimeException("Not found");
        }
        return habit;
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repo.findAll();
    }
}
