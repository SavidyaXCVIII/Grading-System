package com.gs.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private String question;
    private int questionNumber;
    private String[] answers;
    private int[] correctAnswers;
    private int[] studentAnswers;
    private double timeSpent;
    private String status;

 }
