package com.example.restPracice.service.impl;

import com.example.restPracice.dto.CourseDto;
import com.example.restPracice.dto.StudentDTO;
import com.example.restPracice.exeption.NotFoundExeption;
import com.example.restPracice.repository.CourseRepository;
import com.example.restPracice.repository.StudentRepository;
import com.example.restPracice.repository.model.Course;
import com.example.restPracice.repository.model.Student;
import com.example.restPracice.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Set<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student,StudentDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<CourseDto> getStudentCourses(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        return student.getCourses()
                .stream().map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public StudentDTO getById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO save(StudentDTO studentdto) {
        Student student = studentRepository.save(modelMapper.map(studentdto, Student.class));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void addStudentCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundExeption::new);
        Set<Course> courses = student.getCourses();
        courses.add(course);
        student.setCourses(courses);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundExeption::new);
        Set<Course> courses = student.getCourses();
        courses.remove(course);
        student.setCourses(courses);
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long studentId) {
        try {
            studentRepository.deleteById(studentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
