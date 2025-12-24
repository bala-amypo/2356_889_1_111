package com.example.demo.repository;

import com.example.demo.model.HabitProfile;
import java.util.List;

public interface HabitProfileRepository {

    HabitProfile save(HabitProfile habitProfile);

    HabitProfile findByStudentId(Long studentId);

    HabitProfile findById(Long id);  

    List<HabitProfile> findAll();
}
