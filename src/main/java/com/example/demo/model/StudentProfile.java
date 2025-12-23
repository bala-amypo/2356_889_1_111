package com.example.demo.model;

public class StudentProfile {

    private Long id;
    private String email;
    private boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}