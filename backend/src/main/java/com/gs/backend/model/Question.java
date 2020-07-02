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

    private int questionNumber;
    private String[] answers;
    private int[] correctAnswers;
    private int studentAnswer;
    private double timeSpent;

 }
