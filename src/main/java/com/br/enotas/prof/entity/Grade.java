package com.br.enotas.prof.entity;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id @GeneratedValue private Long id;
    private double grade;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
