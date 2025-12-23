package com.example.demo.model;

import com.example.demo.model.enums.*;
import jakarta.persistence.*;

@Entity
@Table(name = "habit_profile")
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public SleepSchedule getSleepSchedule() {
        return sleepSchedule;
    }

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public NoiseTolerance getNoiseTolerance() {
        return noiseTolerance;
    }

    public SocialPreference getSocialPreference() {
        return socialPreference;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setSleepSchedule(SleepSchedule sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public void setNoiseTolerance(NoiseTolerance noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public void setSocialPreference(SocialPreference socialPreference) {
        this.socialPreference = socialPreference;
    }
}