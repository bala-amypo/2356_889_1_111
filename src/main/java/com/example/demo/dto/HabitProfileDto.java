package com.example.demo.dto;

import com.example.demo.model.CleanlinessLevel;
import com.example.demo.model.NoiseTolerance;
import com.example.demo.model.SleepSchedule;
import com.example.demo.model.SocialPreference;

public class HabitProfileDto {

    private Long studentId;
    private SleepSchedule sleepSchedule;
    private int studyHoursPerDay;
    private CleanlinessLevel cleanlinessLevel;
    private NoiseTolerance noiseTolerance;
    private SocialPreference socialPreference;

    public HabitProfileDto() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public SleepSchedule getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(SleepSchedule sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public int getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyHoursPerDay(int studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public NoiseTolerance getNoiseTolerance() {
        return noiseTolerance;
    }

    public void setNoiseTolerance(NoiseTolerance noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public SocialPreference getSocialPreference() {
        return socialPreference;
    }

    public void setSocialPreference(SocialPreference socialPreference) {
        this.socialPreference = socialPreference;
    }
}
