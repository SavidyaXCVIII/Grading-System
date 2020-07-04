package com.gs.backend.repository;

import com.gs.backend.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findFirstByEmail(String email);

}
