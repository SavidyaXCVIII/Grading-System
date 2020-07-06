package com.gs.backend.service;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Student;
import com.gs.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public APIResponse<Student> findStudentById(int studentId) {

        Optional<Student> optionalStudent = studentRepository.findByStudentId(studentId);

        if (optionalStudent.isPresent()){
            return new APIResponse<>(true, optionalStudent.get(), "student found");
        } else {
            return new APIResponse<>(false, "student not found");
        }


    }

    public APIResponse<List<Student>> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();

        if (studentList.size() == 0) {
            return new APIResponse<>(false, "students not found");
        } else {
            return new APIResponse<>(true, studentList, "student search success");
        }
    }
}
