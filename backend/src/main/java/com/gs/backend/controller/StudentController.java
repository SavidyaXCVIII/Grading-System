package com.gs.backend.controller;

import com.gs.backend.model.Student;
import com.gs.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public Optional<Student> getStudent(@RequestParam String email){
        return studentService.getStudent(email);
    }
}
