package com.gs.backend.controller;

import com.gs.backend.model.Assignment;
import com.gs.backend.model.Question;
import com.gs.backend.model.Student;
import com.gs.backend.model.Teacher;
import com.gs.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/teacher")
    public void addTeacher(){
        Teacher teacher = new Teacher("Jane", 199844, "jane@gmail.com", "jane123");
        testService.addTeacher(teacher);
    }

    @GetMapping("/student")
    public void addStudent() {

////        assignment 01
//        Question question1 = new Question("Which of the following is not OOPS concept in Java?", 1,
//                new String[]{"Inheritance", "Encapsulation", "Polymorphism", "Compilation"},
//                new int[]{4}, new int[]{2}, 20);
//
//        Question question2 = new Question("Which of the following is/are a type of polymorphism in Java?",2,
//                new String[]{"Compile time polymorphism","Execution time polymorphism","runtime polymorphism","Multilevel polymorphism"},
//                new int[]{1,3},new int[]{1,4},25);
//
//        Question question3 = new Question("When does method overloading is determined?",3,
//                new String[]{"At run time","At compile time","At coding time","At execution time"},new int[2],new int[2],15);
//
//        Question question4 = new Question("Encapsulation concept in java is",3,
//                new String[]{"Hiding complexity","method hiding","Hiding constructor","None"},new int[]{1},new int[]{1},30);
//
//        Question question5 = new Question("Method overriding is combination of inheritance and polymorphism?",4,
//                new String[]{"True","False"},new int[1],new int[2],10);
//
//        Question[] questions = {question1,question2,question3,question4,question5};
//        Assignment assignment1 = new Assignment("Object Oriented Programming", 5, 1, questions, "Software Engineering");
//
////        assignment2
//        Question question6 = new Question("Which of the following is not OOPS concept in Java?", 1,
//                new String[]{"Inheritance", "Encapsulation", "Polymorphism", "Compilation"},
//                new int[]{4}, new int[]{2}, 20);
//
//        Question question7 = new Question("Which of the following is/are a type of polymorphism in Java?",2,
//                new String[]{"Compile time polymorphism","Execution time polymorphism","runtime polymorphism","Multilevel polymorphism"},
//                new int[]{1,3},new int[]{1,4},25);
//
//        Question question8 = new Question("When does method overloading is determined?",3,
//                new String[]{"At run time","At compile time","At coding time","At execution time"},new int[2],new int[2],15);
//
//        Question question9 = new Question("Encapsulation concept in java is",3,
//                new String[]{"Hiding complexity","method hiding","Hiding constructor","None"},new int[]{1},new int[]{1},30);
//
//        Question question10 = new Question("Method overriding is combination of inheritance and polymorphism?",4,
//                new String[]{"True","False"},new int[1],new int[2],10);
//
//        Question[] questions1 = {question6,question7,question8,question9,question10};
//        Assignment assignment2 = new Assignment("Object Oriented Programming", 5, 1, questions, "Software Engineering");
//
//
////        assignment3
//        Question question11 = new Question("Which of the following is not OOPS concept in Java?", 1,
//                new String[]{"Inheritance", "Encapsulation", "Polymorphism", "Compilation"},
//                new int[]{4}, new int[]{2}, 20);
//
//        Question question12 = new Question("Which of the following is/are a type of polymorphism in Java?",2,
//                new String[]{"Compile time polymorphism","Execution time polymorphism","runtime polymorphism","Multilevel polymorphism"},
//                new int[]{1,3},new int[]{1,4},25);
//
//        Question question13 = new Question("When does method overloading is determined?",3,
//                new String[]{"At run time","At compile time","At coding time","At execution time"},new int[2],new int[2],15);
//
//        Question question14 = new Question("Encapsulation concept in java is",3,
//                new String[]{"Hiding complexity","method hiding","Hiding constructor","None"},new int[]{1},new int[]{1},30);
//
//        Question question15 = new Question("Method overriding is combination of inheritance and polymorphism?",4,
//                new String[]{"True","False"},new int[1],new int[2],10);
//
//        Question[] questions2 = {question1,question2,question3,question4,question5};
//        Assignment assignment3 = new Assignment("Object Oriented Programming", 5, 1, questions, "Software Engineering");


        Student student = new Student(2018401, "John", "john@gmail.com", "john123");
        ArrayList<Assignment> assignments = new ArrayList<>();
//        assignments.add(assignment1);
        student.setAssignments(assignments);
        testService.addStudent(student);

    }

}
