package.com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.presistence.*;
import jakarta.validation.constraints.Min;

public class HabitProfile{
    @Id
    private Long id;
    private Long studentId;
    private String sleepSchedule;
    @Min(100)
    private int studyHoursPerDay;
    private String cleanlinessLevel;
    public HabitProfile(Long id, Long studentId, String sleepSchedule, @Min(100) int studyHoursPerDay,
            String cleanlinessLevel, String noiseTolerance, String socialPerference, LocalDateTime updatedAt) {
        this.id = id;
        this.studentId = studentId;
        this.sleepSchedule = sleepSchedule;
        this.studyHoursPerDay = studyHoursPerDay;
        this.cleanlinessLevel = cleanlinessLevel;
        this.noiseTolerance = noiseTolerance;
        this.socialPerference = socialPerference;
        this.updatedAt = updatedAt;
    }
    private String noiseTolerance;
    private String socialPerference;
    private LocalDateTime updatedAt;
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
    public String getSleepSchedule() {
        return sleepSchedule;
    }
    public void setSleepSchedule(String sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }
    public int getStudyHoursPerDay() {
        return studyHoursPerDay;
    }
    public void setStudyHoursPerDay(int studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }
    public String getCleanlinessLevel() {
        return cleanlinessLevel;
    }
    public void setCleanlinessLevel(String cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }
    public String getNoiseTolerance() {
        return noiseTolerance;
    }
    public void setNoiseTolerance(String noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }
    public String getSocialPerference() {
        return socialPerference;
    }
    public void setSocialPerference(String socialPerference) {
        this.socialPerference = socialPerference;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}