package com.example.restPracice.service;

import com.example.restPracice.dto.CourseDto;
import com.example.restPracice.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    List<CourseDto> getStudentCourses(Long studentId);
    StudentDTO getById(Long studentId);
    StudentDTO save(StudentDTO studentdto);
    void addStudentCourse(Long studentId,Long courseId);
    void deleteStudentCourse(Long studentId,Long courseId);
    void deleteById(Long studentId);
}
