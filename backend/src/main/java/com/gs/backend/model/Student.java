package com.gs.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int studentId;
    private String studentName;
    private String email;
    private String password;
    private ArrayList<Assignment> assignments;

    public Student(int studentId, String studentName, String email, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.password = password;
    }

    public void setAssignments(Assignment assignment) {
        if (assignment != null) {
            assignments.add(assignment);
        }else {
            System.out.println("Object is null");
        }
    }
}
