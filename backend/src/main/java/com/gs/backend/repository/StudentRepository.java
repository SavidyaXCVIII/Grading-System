package com.gs.backend.repository;

import com.gs.backend.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

    Student findFirstByEmail(String email);

}
