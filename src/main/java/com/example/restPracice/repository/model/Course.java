package com.example.restPracice.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;
}
