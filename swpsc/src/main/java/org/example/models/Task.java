package org.example.models;

public class Task {
    private String description;
    private String assignedTo;


    public Task(String description, String assignedTo) {
        this.description = description;
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String toString() {
        return "[Task] " + description + " → " + assignedTo;
    }
}