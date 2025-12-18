package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HabitProfile;
public interface Ha extends JpaRepository<HabitProfile,Long>{
    
}