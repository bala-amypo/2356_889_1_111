package com.example.demo.model;

public class HabitProfile {

    private Long id;
    private Long studentId;
    private int studyHoursPerDay;

    private CleanlinessLevel cleanlinessLevel;
    private NoiseTolerance noiseTolerance;
    private SleepSchedule sleepSchedule;
    private SocialPreference socialPreference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    // 🔴 REQUIRED BY HabitProfileServiceImpl
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

    public SleepSchedule getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(SleepSchedule sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public SocialPreference getSocialPreference() {
        return socialPreference;
    }

    public void setSocialPreference(SocialPreference socialPreference) {
        this.socialPreference = socialPreference;
    }
}
