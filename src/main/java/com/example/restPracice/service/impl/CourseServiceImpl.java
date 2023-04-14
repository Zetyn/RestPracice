package com.example.restPracice.service.impl;

import com.example.restPracice.dto.CourseDto;
import com.example.restPracice.dto.StudentDTO;
import com.example.restPracice.exeption.NotFoundExeption;
import com.example.restPracice.repository.CourseRepository;
import com.example.restPracice.repository.model.Course;
import com.example.restPracice.repository.model.Student;
import com.example.restPracice.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAllStudentOnCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundExeption::new);
        List<Student> students = course.getStudents();
        return students.stream().map(student -> modelMapper.map(student,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundExeption::new);
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        Course course = courseRepository.save(modelMapper.map(courseDto, Course.class));
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public void deleteById(Long courseId) {
        try {
            courseRepository.deleteById(courseId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
