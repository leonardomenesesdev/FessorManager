package com.br.enotas.prof.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id @GeneratedValue private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classroom;
    @JoinTable(
            name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers = new ArrayList<>();
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();
}
