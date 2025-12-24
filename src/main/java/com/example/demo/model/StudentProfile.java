package com.example.demo.model;

public class StudentProfile {

    private Long id;
    private String name;
    private String email;
    private HabitProfile habitProfile;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public HabitProfile getHabitProfile() { return habitProfile; }
    public void setHabitProfile(HabitProfile habitProfile) { this.habitProfile = habitProfile; }
}
