package com.gs.backend.service;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Student;
import com.gs.backend.model.Teacher;
import com.gs.backend.repository.StudentRepository;
import com.gs.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogInService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;


    public APIResponse<Integer> authenticateUser(String email, String password, String type) {
        if (type.equals("Teacher")) {
            Optional<Teacher> teacher = teacherRepository.findFirstByEmail(email);
            if (teacher.isPresent()) {
                if (teacher.get().getPassword().equals(password)) {
                    return new APIResponse<>(true, teacher.get().getTeacherId(),"Login Successful");
                } else {
                    return new APIResponse<>(false, "The password that you've entered is incorrect.");
                }
            } else {

                return new APIResponse<>(false, "Teacher not found");
            }
        }
        else  {
            Optional<Student> student = studentRepository.findByEmail(email);
            if (student.isPresent()) {
                if (student.get().getPassword().equals(password)) {
                    return new APIResponse<>(true, student.get().getStudentId(), "Login Successful");
                } else {
                    return new APIResponse<>(false, "The password that you've entered is incorrect.");
                }
            } else {

                return new APIResponse<>(false, "Student not found");
            }
        }

    }

}
