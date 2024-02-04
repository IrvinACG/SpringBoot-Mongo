package com.iacg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iacg.document.Student;
import java.util.Optional;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	Optional<Student> findByEmail(String email);
	
}
