package com.gs.backend.service;

import com.gs.backend.dto.APIResponse;
import com.gs.backend.model.Student;
import com.gs.backend.model.Teacher;
import com.gs.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public APIResponse<Teacher> findTeacherById(int teacherId) {

        Optional<Teacher> optionalTeacher = teacherRepository.findFirstByTeacherId(teacherId);
        System.out.println(optionalTeacher);

        if (optionalTeacher.isPresent()){
            return new APIResponse<>(true, optionalTeacher.get(), "teacher found");
        } else {
            return new APIResponse<>(false, "teacher not found");
        }


    }


    public Optional<Teacher> getTeacher(String email) {
        return teacherRepository.findFirstByEmail(email);
    }


}
