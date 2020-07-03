package com.gs.backend.service;

import com.gs.backend.model.Teacher;
import com.gs.backend.model.User;
import com.gs.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public User authenticateUser(String email, String password) {
        User user = new User();
        Teacher teacher = null;
        teacher = teacherRepository.findFirstByEmail(email);
        if (teacher == null) {
            user.setEmail(false);
        }else {
            user.setEmail(true);
            user.setPassword(password.equals(teacher.getPassword()));
        }
        return user;
    }
}
