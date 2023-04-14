package com.example.restPracice.web;

import com.example.restPracice.dto.CourseDto;
import com.example.restPracice.dto.StudentDTO;
import com.example.restPracice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<CourseDto> getAllCourses () {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}/students")
    public List<StudentDTO> getStudentsOnCourse(@PathVariable("id") Long id) {
        return courseService.getAllStudentOnCourse(id);
    }

    @GetMapping("/course/{id}")
    public CourseDto getById (@PathVariable("id") Long id) {
        return courseService.getById(id);
    }

    @PostMapping("/createCourse")
    public CourseDto createCourse (@RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @DeleteMapping("/course/{id}/delete")
    public void deleteCourse (@PathVariable("id") Long id) {
        courseService.deleteById(id);
    }
}
