package com.gs.backend.controller;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Teacher;
import com.gs.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Teacher>> findByTeacherId(@PathVariable int id) {

        return ResponseEntity.ok(teacherService.findTeacherById(id));
    }

    @GetMapping("")
    public Optional<Teacher> getTeacher(@RequestParam String email){
        return teacherService.getTeacher(email);
    }

}
