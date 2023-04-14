package com.example.restPracice.service;

import com.example.restPracice.dto.CourseDto;
import com.example.restPracice.dto.StudentDTO;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();
    List<StudentDTO> getAllStudentOnCourse(Long courseId);
    CourseDto getById(Long courseId);
    CourseDto save(CourseDto course);
    void deleteById(Long courseId);
}
