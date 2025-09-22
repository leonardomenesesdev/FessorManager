package com.br.enotas.prof.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;

    @ManyToMany(mappedBy = "teachers")
    private List<Class> classes = new ArrayList<>();

}
