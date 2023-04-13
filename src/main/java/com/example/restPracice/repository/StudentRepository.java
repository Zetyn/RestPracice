package com.example.restPracice.repository;

import com.example.restPracice.repository.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StudentRepository extends CrudRepository<Student,Long> {
    Set<Student> findAll();
}
