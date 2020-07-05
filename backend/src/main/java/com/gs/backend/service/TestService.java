package com.gs.backend.service;

import com.gs.backend.model.Student;
import com.gs.backend.model.Teacher;
import com.gs.backend.repository.StudentRepository;
import com.gs.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    };
}
