package com.example.demo.repository;

import com.example.demo.model.StudentProfile;
import java.util.Optional;

public interface StudentProfileRepository {
    Optional<StudentProfile> findByEmail(String email);
}
