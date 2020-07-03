package com.gs.backend.repository;

import com.gs.backend.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

    Teacher findFirstByEmail(String email);

}
