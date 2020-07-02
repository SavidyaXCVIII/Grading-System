package com.gs.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    private String assignmentName;
    private int numberOfQuestions;
    private int numberOfAttempts;
    private Question[] questions;


}
