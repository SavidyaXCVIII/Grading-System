package com.gs.backend.controller;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Student;
import com.gs.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Student>> findByStudentId(@PathVariable int id) {

        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("/")
    public ResponseEntity<APIResponse<List<Student>>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
