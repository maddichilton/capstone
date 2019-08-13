package com.example.capstone.models;

import java.util.ArrayList;

public class AssignmentData {

    static ArrayList<Assignment> assignments = new ArrayList<>();

    // getAll
    public static ArrayList<Assignment> getAll() {
        return assignments;
    }

    // add
    public static void add(Assignment newAssignment) {
        assignments.add(newAssignment);
    }

    // remove
    public static void remove(int id) {
        Assignment assignmentToRemove = getById(id);
        assignments.remove(assignmentToRemove);
    }

    // getById
    public static Assignment getById(int id) {

        Assignment assignment1 = null;

        for (Assignment thisAssignment : assignments) {
            if (thisAssignment.getAssignmentID() == id) {
                assignment1 = thisAssignment;
            }
        }

        return assignment1;
    }
}
