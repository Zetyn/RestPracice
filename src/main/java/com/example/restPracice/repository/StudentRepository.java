package com.example.restPracice.repository;


import com.example.restPracice.repository.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
