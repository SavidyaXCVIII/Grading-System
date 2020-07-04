package com.gs.backend.service;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Teacher;
import com.gs.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogInService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public APIResponse<String> authenticateUser(String email, String password) {
        Optional<Teacher> teacher = teacherRepository.findFirstByEmail(email);
        if (teacher.isPresent()) {
            if (teacher.get().getPassword().equals(password)){
                return new APIResponse<>(true, "Login Successful");
            }
            else {
                return new APIResponse<>(false, "Incorrect Password");
            }
        }else {

            return new APIResponse<>(false, "User not found");
        }
    }
}
