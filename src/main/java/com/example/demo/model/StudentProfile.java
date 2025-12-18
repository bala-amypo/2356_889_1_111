package.com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.presistence.*;

public class StudentProfile{
    @Id
    private Long id;
    private String studentId;
    private String fullName;
    private String email;
    private String department;
    private int yearlevel;
    private boolean active;
    private LocalDateTime createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public StudentProfile(Long id, String studentId, String fullName, String email, String department, int yearlevel,
            boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.yearlevel = yearlevel;
        this.active = active;
        this.createdAt = createdAt;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getYearlevel() {
        return yearlevel;
    }
    public void setYearlevel(int yearlevel) {
        this.yearlevel = yearlevel;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}