package com.gs.backend.repository;

import com.gs.backend.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

    Optional<Teacher> findFirstByEmail(String email);

}
