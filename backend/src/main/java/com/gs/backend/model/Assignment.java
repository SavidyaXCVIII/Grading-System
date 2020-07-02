package com.gs.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    private String assignmentName;
    private double timeSpent;
    private int numberOfQuestions;
    private int numberOfAttempts;
    private Question[] questions;
}
