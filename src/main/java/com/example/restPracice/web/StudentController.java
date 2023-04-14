package com.example.restPracice.web;

import com.example.restPracice.dto.CourseDto;
import com.example.restPracice.dto.StudentDTO;
import com.example.restPracice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentDTO getById(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }

    @GetMapping("/student/{id}/courses")
    public List<CourseDto> getStudentCourses(@PathVariable("id") Long id) {
        return studentService.getStudentCourses(id);
    }

    @PostMapping("/createStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    @PostMapping("/student/{studentId}/add/{courseId}")
    public void addStudentCourse(@PathVariable("studentId") Long studentId,@PathVariable("courseId") Long courseId) {
        studentService.addStudentCourse(studentId,courseId);
    }

    @DeleteMapping("/student/{studentId}/delete/{courseId}")
    public void deleteStudentCourse (@PathVariable("studentId") Long studentId,@PathVariable("courseId") Long courseId) {
        studentService.deleteStudentCourse(studentId,courseId);
    }

    @DeleteMapping("/student/{id}/delete")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

}
