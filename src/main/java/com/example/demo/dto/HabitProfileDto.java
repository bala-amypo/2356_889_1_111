package com.example.demo.dto;

import com.example.demo.model.*;

public class HabitProfileDto {

    private Long studentId;
    private SleepSchedule sleepSchedule;
    private CleanlinessLevel cleanlinessLevel;
    private NoiseTolerance noiseTolerance;
    private SocialPreference socialPreference;

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public SleepSchedule getSleepSchedule() { return sleepSchedule; }
    public void setSleepSchedule(SleepSchedule sleepSchedule) { this.sleepSchedule = sleepSchedule; }

    public CleanlinessLevel getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }

    public NoiseTolerance getNoiseTolerance() { return noiseTolerance; }
    public void setNoiseTolerance(NoiseTolerance noiseTolerance) { this.noiseTolerance = noiseTolerance; }

    public SocialPreference getSocialPreference() { return socialPreference; }
    public void setSocialPreference(SocialPreference socialPreference) { this.socialPreference = socialPreference; }
}