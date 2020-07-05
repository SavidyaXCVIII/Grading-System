package com.gs.backend.controller;

import com.gs.backend.model.Assignment;
import com.gs.backend.model.Student;
import com.gs.backend.model.Teacher;
import com.gs.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    }

}
