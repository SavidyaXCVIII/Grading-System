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

        Student student = new Student(2018401, "John", "john@gmail.com", "john123");
        Question question1 = new Question("Which of the following is not OOPS concept in Java?", 1,
                new String[]{"Inheritance", "Encapsulation", "Polymorphism", "Compilation"},
                new int[]{4}, 2, 20);
        Question[] questions = {question1};
        Assignment assignment1 = new Assignment("Semester 1 ICT", 5, 1, questions, "Software Engineering");

        student.setAssignments(assignment1);

    }

}
