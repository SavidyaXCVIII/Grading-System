package com.gs.backend.controller;

import com.gs.backend.model.Student;
import com.gs.backend.model.Teacher;
import com.gs.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public Optional<Teacher> getTeacher(@RequestParam String email){
        return teacherService.getTeacher(email);
    }

}
