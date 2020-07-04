package com.gs.backend.service;

import com.gs.backend.model.Student;
import com.gs.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudent(String email) {
        return studentRepository.findFirstByEmail(email);
    }
}
