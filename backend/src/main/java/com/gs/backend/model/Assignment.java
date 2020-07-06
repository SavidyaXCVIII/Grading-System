package com.gs.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    private String assignmentName;
    private int numberOfQuestions;
    private int numberOfAttempts;
    private Question[] questions;
    private String course;
    private int mark;

    public Assignment(String assignmentName, int numberOfAttempts, Question[] questions, String course) {
        this.assignmentName = assignmentName;
        this.numberOfAttempts = numberOfAttempts;
        this.questions = questions;
        this.course = course;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
        numberOfQuestions = questions.length;
    }
}
