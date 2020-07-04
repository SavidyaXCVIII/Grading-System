package com.gs.backend.controller;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Teacher;
import com.gs.backend.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")
public class LogInController {

    @Autowired
    private LogInService logInService;


    @GetMapping("/addTeacher")
    public void addTeacher(){
        Teacher teacher = new Teacher("Jane", 199844, "jane@gmail.com", "jane123");
        logInService.addTeacher(teacher);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> sendStatus(@RequestParam String email,
                                                  @RequestParam String password){

        if (email == null || email.trim().length() == 0){

            return ResponseEntity.badRequest().body( new APIResponse<>(false, "Email is missing"));
        }

        return ResponseEntity.ok(logInService.authenticateUser(email, password));
    }

}
