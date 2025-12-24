package com.example.demo.service;

import java.util.List;
import com.example.demo.model.StudentProfile;

public interface StudentProfileService {

    StudentProfile saveProfile(StudentProfile profile);

    StudentProfile getProfileById(Long id);

    StudentProfile getProfileByStudentId(String studentId);

    List<StudentProfile> getAllProfiles();

   
    StudentProfile updateStudentStatus(Long id, boolean active);
}
