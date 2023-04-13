package com.example.restPracice.repository;

import com.example.restPracice.repository.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CourseRepository extends CrudRepository<Course,Long> {
    Set<Course> findAll();
}
