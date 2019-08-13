package com.example.capstone.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Assignment {

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @NotNull
    @Size(min=6)
    private String deadline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    private int assignmentID;
    private static int nextID = 1;

    public Assignment(String name, String description, String deadline) {
        this();
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }

    public Assignment() {
        assignmentID = nextID;
        nextID++;
    }


}
