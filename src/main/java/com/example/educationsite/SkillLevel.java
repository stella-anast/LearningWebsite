package com.example.educationsite;

public enum SkillLevel {
    BEGINNER,
    INTERMEDIATE,
    PRO;
    // Method to get the next skill level
    public SkillLevel next() {
        switch (this) {
            case BEGINNER:
                return INTERMEDIATE;
            case INTERMEDIATE:
                return PRO;
            case PRO:
                return PRO; // Already at the highest level
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
