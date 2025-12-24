package com.example.demo.repository;

import com.example.demo.model.HabitProfile;
import java.util.Optional;

public interface HabitProfileRepository {
    Optional<HabitProfile> findById(Long id);
}
