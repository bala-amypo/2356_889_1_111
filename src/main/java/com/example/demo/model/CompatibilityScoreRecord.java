package com.example.demo.model;

public class CompatibilityScoreRecord {

    private Long id;
    private CompatibilityLevel compatibilityLevel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }
}
