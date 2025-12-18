package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MatchAttemp;

public interface HabitProfileRepository extends JpaRepository<HabitProfile,Long>{
    
}