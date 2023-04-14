package com.example.restPracice.repository;

import com.example.restPracice.repository.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {

}
