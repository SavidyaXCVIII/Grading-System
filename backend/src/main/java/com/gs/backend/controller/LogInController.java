package com.gs.backend.controller;

import com.gs.backend.model.Teacher;
import com.gs.backend.model.User;
import com.gs.backend.repository.TeacherRepository;
import com.gs.backend.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LogInController {

    @Autowired
    private LogInService logInService;


    @GetMapping("/addTeacher")
    public void addTeacher(){
        Teacher teacher = new Teacher("Jane", 199844, "jane@gmail.com", "jane123");
        logInService.addTeacher(teacher);
    }

    @PostMapping("/userAuthenticate")
    public User sendStatus(@RequestParam String email,
                           @RequestParam String password){
        return logInService.authenticateUser(email, password);
    }

}
